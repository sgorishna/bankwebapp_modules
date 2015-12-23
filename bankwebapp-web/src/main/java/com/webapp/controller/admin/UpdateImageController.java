package com.webapp.controller.admin;

import static com.webapp.utils.WebappConstants.MAX_PHOTO_SIZE;


import static com.webapp.utils.WebappConstants.uploadPhotoPath;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.Part;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.model.Customer;

import com.webapp.utils.ImageLoadHelper;

@WebServlet("/admin/updateImage")
@MultipartConfig
public class UpdateImageController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long IdCustomer = Long.parseLong(request.getParameter("IdCustomer"));
		Customer customer = getCommonService().findById(IdCustomer);
		request.setAttribute("customer", customer);

		request.setAttribute("path", uploadPhotoPath(request) + File.separator + customer.getIdCustomer() + ".JPG");

		gotoToJSP("admin/updateCustomer3.jsp", request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long IdCustomer = Long.parseLong(request.getParameter("IdCustomer"));

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

			if (inputStream != null) {

				if (bytes.length > MAX_PHOTO_SIZE) {

					ImageLoadHelper.makeDir(uploadPhotoPath(request));

					if (ImageLoadHelper.checkImgType(photoName) == true) {

						ImageLoadHelper.saveImgOnDisk(customer, IdCustomer, photoName, filePart,
								uploadPhotoPath(request), getCommonService());
						redirectRequest("/admin/updateCustomer.php?IdCustomer=" + IdCustomer, request, response);

					} else {

						redirectRequest("/admin/updateCustomer.php?IdCustomer=" + IdCustomer, request, response);

					}

				} else {

					ImageLoadHelper.saveImgInDatabase(getCommonService(), IdCustomer, customer, bytes);

					redirectRequest("/admin/updateCustomer.php?IdCustomer=" + IdCustomer, request, response);
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
