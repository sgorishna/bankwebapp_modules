package com.webapp.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class WebappUtils {

	public static String getFileName(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	public static void showImage(byte[] imageInByte, OutputStream os, HttpServletResponse resp) {

		try {

			os = resp.getOutputStream();

			os.write(imageInByte);

			os.flush();

		} catch (Exception e) {

			Logger.getLogger(WebappUtils.class.getName()).log(Level.DEBUG, null, e);
		} finally {

			if (os != null)
				try {
					os.close();
				} catch (IOException e) {
					Logger.getLogger(WebappUtils.class.getName()).log(Level.DEBUG, null, e);

				}
		}

	}

	public static void loadImageFromFile(byte[] imageInByte, ByteArrayOutputStream baos, OutputStream os, BufferedImage imgInFile, HttpServletResponse resp) {

		try {
			baos = new ByteArrayOutputStream();
			ImageIO.write(imgInFile, "jpg", baos);
			baos.flush();
			imageInByte = baos.toByteArray();

			os = resp.getOutputStream();

			os.write(imageInByte);
			os.flush();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (baos != null)
				try {
					baos.close();
				} catch (IOException e) {
					Logger.getLogger(WebappUtils.class.getName()).log(Level.DEBUG, null, e);
				}
			if (os != null)
				try {
					os.close();
				} catch (IOException e) {
					Logger.getLogger(WebappUtils.class.getName()).log(Level.DEBUG, null, e);
				}
		}

	}

}
