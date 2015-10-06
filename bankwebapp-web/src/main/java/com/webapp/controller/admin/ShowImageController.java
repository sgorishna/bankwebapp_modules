package com.webapp.controller.admin;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.actions.AbstractServletHandler;
import com.webapp.model.Customer;
import com.webapp.utils.CacheImitation;
import com.webapp.utils.WebappUtils;

@WebServlet("/admin/showImage.php")
public class ShowImageController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		long IdCustomer = Long.parseLong(req.getParameter("IdCustomer"));
		Customer customer = getCommonService().findById(IdCustomer);
		req.setAttribute("customer", customer);

		File img = null;
		BufferedImage imgInFile = null;
		byte[] imageInByte = null;

		String applicationPath = req.getServletContext().getRealPath("");
		String uploadPhotoPath = applicationPath + File.separator + "recources" + File.separator + UPLOAD_DIR;

		img = new File(uploadPhotoPath + File.separator + customer.getIdCustomer() + ".JPG");

		if (img.isFile()) {
			imgInFile = ImageIO.read(img);
		}

		if (imgInFile != null) {

			WebappUtils.loadImageFromFile(imageInByte, new ByteArrayOutputStream(), resp.getOutputStream(), imgInFile, resp);

		} else {

			imageInByte = CacheImitation.findInCache(IdCustomer);

			if (imageInByte != null) {

				WebappUtils.showImage(imageInByte, resp.getOutputStream(), resp);

			} else {

				imageInByte = customer.getPhoto();

				if (imageInByte != null) {

					CacheImitation.putInCache(IdCustomer, imageInByte);

					WebappUtils.showImage(imageInByte, resp.getOutputStream(), resp);
				} else {

					img = new File(uploadPhotoPath + File.separator + "default.JPG");

					if (img.isFile()) {
						imgInFile = ImageIO.read(img);
					}

					WebappUtils.loadImageFromFile(imageInByte, new ByteArrayOutputStream(), resp.getOutputStream(), imgInFile, resp);

				}
			}

		}

	}
}
