package com.webapp.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class ImageLoadHelper {

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

			Logger.getLogger(ImageLoadHelper.class.getName()).log(Level.DEBUG, null, e);
		} finally {

			if (os != null)
				try {
					os.close();
				} catch (IOException e) {
					Logger.getLogger(ImageLoadHelper.class.getName()).log(Level.DEBUG, null, e);

				}
		}

	}

	public static void loadImageFromFile(File img, HttpServletResponse resp) {

		FileInputStream fis = null;

		OutputStream os = null;

		try {

			fis = new FileInputStream(img);

			os = resp.getOutputStream();

			byte[] b = new byte[2048];
			int length;

			while ((length = fis.read(b)) != -1) {
				os.write(b, 0, length);
			}

		} catch (Exception e) {
			Logger.getLogger(ImageLoadHelper.class.getName()).log(Level.DEBUG, null, e);
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					Logger.getLogger(ImageLoadHelper.class.getName()).log(Level.DEBUG, null, e);
				}
			if (os != null)
				try {
					os.close();
				} catch (IOException e) {
					Logger.getLogger(ImageLoadHelper.class.getName()).log(Level.DEBUG, null, e);
				}
		}

	}

}
