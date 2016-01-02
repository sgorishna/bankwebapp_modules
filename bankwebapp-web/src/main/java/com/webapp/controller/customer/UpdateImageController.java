package com.webapp.controller.customer;

import static com.webapp.utils.WebappConstants.CURRENT_SESSION_ACCOUNT;
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

@WebServlet("/customer/updateImage")
@MultipartConfig
public class UpdateImageController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Customer customer = (Customer) request.getSession().getAttribute(CURRENT_SESSION_ACCOUNT);
		

		request.setAttribute("path", uploadPhotoPath(request) + File.separator + customer.getIdCustomer() + ".JPG");

		gotoToJSP("admin/updateCustomer3.jsp", request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//long IdCustomer = Long.parseLong(request.getParameter("IdCustomer"));
		
		//Customer current = (Customer) request.getSession().getAttribute(CURRENT_SESSION_ACCOUNT);

		InputStream inputStream = null;

		Part filePart = request.getPart("photo");

		String photoName = ImageLoadHelper.getFileName(filePart);

		if (filePart != null) {

			inputStream = filePart.getInputStream();

		}

		try {
			final byte[] bytes = new byte[inputStream.available()];
			inputStream.read(bytes);

			Customer customer = (Customer) request.getSession().getAttribute(CURRENT_SESSION_ACCOUNT);

			if (inputStream != null) {

				if (bytes.length > MAX_PHOTO_SIZE) {

					ImageLoadHelper.makeDir(uploadPhotoPath(request));

					if (ImageLoadHelper.checkImgType(photoName) == true) {

						ImageLoadHelper.saveImgOnDisk(customer, customer.getIdCustomer(), photoName, filePart,
								uploadPhotoPath(request), getCommonService());
						
						request.getSession().removeAttribute(CURRENT_SESSION_ACCOUNT);
						request.getSession().setAttribute(CURRENT_SESSION_ACCOUNT, customer);
						
						redirectRequest("/customer/editProfile.php", request, response);

					} else {

						redirectRequest("/customer/editProfile.php", request, response);

					}

				} else {

					ImageLoadHelper.saveImgInDatabase(getCommonService(), customer.getIdCustomer(), customer, bytes);

					request.getSession().removeAttribute(CURRENT_SESSION_ACCOUNT);
					request.getSession().setAttribute(CURRENT_SESSION_ACCOUNT, customer);
					
					redirectRequest("/customer/editProfile.php", request, response);
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
