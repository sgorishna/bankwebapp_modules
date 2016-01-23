package com.webapp.utils;

import static com.webapp.utils.WebappConstants.CURRENT_SESSION_ACCOUNT;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.webapp.model.Customer;
import com.webapp.services.CustomerService;

public class SecurityUtills {

	public static boolean iskRequestedIdAccEqualCurrentIdCustomer(
			HttpServletRequest request, CustomerService customerService,
			String idAccount) {

		Customer current = (Customer) request.getSession().getAttribute(
				CURRENT_SESSION_ACCOUNT);

		long idCustomer = customerService.findIdCustomerByIdAccount(Long
				.parseLong(idAccount));

		if (idCustomer == current.getIdCustomer()) {

			return true;
		} else
			return false;

	}

	public static String generateMD5Hash(String email, String login) {

		String token = email + login;

		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(token.getBytes());

			byte byteData[] = md.digest();

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
						.substring(1));
			}

			return sb.toString();

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();

			return null;
		}

	}

	public static String generateVerificationLink(HttpServletRequest request,
			String login, String hash) {

		String link = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + request.getContextPath()
				+ "/verify?login=" + login + "&hash=" + hash;

		return link;
	}

	public static boolean compareCredentials(Customer c, String login,
			String hash) {

		String c_login = c.getLogin();

		String c_hash = c.getHash();

		if (c_login.equals(login)) {

			if (c_hash.equals(hash)) {
				return true;
			} else {
				return false;
			}
		}else{
			return false;
		}

	}

}
