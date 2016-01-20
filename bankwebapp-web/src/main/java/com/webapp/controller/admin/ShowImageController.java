package com.webapp.controller.admin;

import static com.webapp.utils.WebappConstants.applicationPath;

import static com.webapp.utils.WebappConstants.UPLOAD_DIR;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.model.Customer;
import com.webapp.utils.CacheImitation;
import com.webapp.utils.ImageLoadHelper;
import static com.webapp.utils.WebappConstants.applicationPath;

@WebServlet("/admin/showImage.php")
public class ShowImageController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		long IdCustomer = Long.parseLong(req.getParameter("IdCustomer"));
		Customer customer = getCommonService().findById(IdCustomer);
		req.setAttribute("customer", customer);

		File img = null;

		byte[] imageInByte;

		
		String uploadPhotoPath = applicationPath(req) + File.separator + "recources" + File.separator + UPLOAD_DIR;

		img = new File(uploadPhotoPath + File.separator + customer.getIdCustomer() + ".JPG");

		if (img.isFile()) {
			ImageLoadHelper.loadImageFromFile(img, resp);
		} else if (CacheImitation.findInCache(IdCustomer) != null) {

			byte[] a = CacheImitation.findInCache(IdCustomer);

			ImageLoadHelper.showImage(a, resp.getOutputStream(), resp);
		} else if ((imageInByte = customer.getPhoto()) != null) {

			CacheImitation.putInCache(IdCustomer, imageInByte);

			ImageLoadHelper.showImage(imageInByte, resp.getOutputStream(), resp);

		} else {

			img = new File(uploadPhotoPath + File.separator + "default.JPG");

			ImageLoadHelper.loadImageFromFile(img, resp);

		}

	}
}
