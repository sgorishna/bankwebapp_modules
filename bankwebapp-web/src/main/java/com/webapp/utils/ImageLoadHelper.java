package com.webapp.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.webapp.model.Customer;

import com.webapp.services.CustomerService;

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

	public static boolean checkImgType(String photoName){
		
		if (photoName.endsWith(".JPG") || photoName.endsWith(".PNG") || photoName.endsWith(".jpg") || photoName.endsWith(".png")){
			return true;
		}else{
			return false;
		}
	}
	
	public static File makeDir(String pathToDir ){
		
		File photoSaveDir = new File(pathToDir);
		if (!photoSaveDir.exists()) {
			photoSaveDir.mkdirs();
		}
		
		return photoSaveDir;
	}
	
	public static void saveImgOnDisk( Customer customer, Long IdCustomer, String photoName , Part filePart, String uploadPhotoPath, CustomerService service) throws IOException{
		
		customer.setIdCustomer(IdCustomer);

		photoName = "" + customer.getIdCustomer() + ".JPG";

		filePart.write(uploadPhotoPath + File.separator + photoName);

		customer.setPhotoPath(uploadPhotoPath + File.separator + photoName);

		service.updateImage(customer);

		CacheImitation.removeFromCache(IdCustomer);
		
		
	}
	
	public static void saveImgInDatabase(CustomerService service, Long IdCustomer , Customer customer, byte[] imgbytes){
		
		Customer c = service.findById(IdCustomer);

		String path = c.getPhotoPath();

		if (path != null) {

			File file = new File(path);
			file.delete();
		}

		customer.setPhoto(imgbytes);

		customer.setIdCustomer(IdCustomer);
		service.updateImage(customer);

		CacheImitation.removeFromCache(IdCustomer);
	}
}
