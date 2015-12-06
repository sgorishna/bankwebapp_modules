package com.webapp.controller.admin;

import static com.webapp.utils.WebappConstants.MAX_PHOTO_SIZE;
import static com.webapp.utils.WebappConstants.UPLOAD_DIR;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.model.Customer;
import com.webapp.utils.CacheImitation;
import com.webapp.utils.ImageLoadHelper;

@MultipartConfig
public class UpdateCustomerController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long IdCustomer = Long.parseLong(request.getParameter("IdCustomer"));
		Customer customer = getCommonService().findById(IdCustomer);
		request.setAttribute("customer", customer);

		String applicationPath = request.getServletContext().getRealPath("");
		String uploadPhotoPath = applicationPath + File.separator + "recources" + File.separator + UPLOAD_DIR;
		request.setAttribute("path", uploadPhotoPath + File.separator + customer.getIdCustomer() + ".JPG");

		gotoToJSP("admin/updateCustomer.jsp", request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String applicationPath = request.getServletContext().getRealPath("");
		String uploadPhotoPath = applicationPath + File.separator + "recources" + File.separator + UPLOAD_DIR;

		boolean uploadPhotoStatus = false;

		InputStream inputStream = null;

		Part filePart = request.getPart("photo");

		String photoName = ImageLoadHelper.getFileName(filePart);

		if (filePart != null) {

			inputStream = filePart.getInputStream();

		}

		try {
			final byte[] bytes = new byte[inputStream.available()];
			inputStream.read(bytes);

			Customer customer = new Customer();
			String selectedRoles[] = request.getParameterValues("role");
			customer.setName(request.getParameter("name"));
			customer.setGender(request.getParameter("gender"));
			customer.setLogin(request.getParameter("login"));
			customer.setPassword(request.getParameter("password"));
			customer.setEmail(request.getParameter("email"));

			if (inputStream != null) {

				if (bytes.length > MAX_PHOTO_SIZE) {

					/*
					 * String applicationPath =
					 * request.getServletContext().getRealPath(""); String
					 * uploadPhotoPath = applicationPath + File.separator +
					 * "recources" + File.separator + UPLOAD_DIR;
					 */

					File photoSaveDir = new File(uploadPhotoPath);
					if (!photoSaveDir.exists()) {
						photoSaveDir.mkdirs();
					}

					if (photoName.endsWith(".JPG") || photoName.endsWith(".PNG") || photoName.endsWith(".jpg") || photoName.endsWith(".png")) {

						customer.setIdCustomer(Long.parseLong(request.getParameter("idCustomer")));

						photoName = "" + customer.getIdCustomer() + ".JPG";

						filePart.write(uploadPhotoPath + File.separator + photoName);

						customer.setPhotoPath(uploadPhotoPath + File.separator + photoName);

						uploadPhotoStatus = true;

						HttpSession session = request.getSession();
						session.setAttribute("uploadPhotoStatus", uploadPhotoStatus);

						getAdminService().update(customer, selectedRoles);

						CacheImitation.removeFromCache(Long.parseLong(request.getParameter("idCustomer")));

						redirectRequest("/admin/home.php", request, response);

					} else {

						request.getSession().setAttribute("uploadPhotoStatus", uploadPhotoStatus);

						redirectRequest("/admin/updateCustomer.php?IdCustomer=" + Long.parseLong(request.getParameter("idCustomer")), request, response);

					}

				} else {

					Customer c = getCommonService().findById(Long.parseLong(request.getParameter("idCustomer")));

					String path = c.getPhotoPath();

					if (path != null) {

						File file = new File(path);
						file.delete();
					}

					customer.setPhoto(bytes);

					customer.setIdCustomer(Long.parseLong(request.getParameter("idCustomer")));
					getAdminService().update(customer, selectedRoles);

					CacheImitation.removeFromCache(Long.parseLong(request.getParameter("idCustomer")));

					redirectRequest("/admin/home.php", request, response);
				}

			}

		} catch (IOException ex) {

		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}

}
