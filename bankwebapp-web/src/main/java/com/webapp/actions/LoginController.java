package com.webapp.actions;

import static com.webapp.utils.WebappConstants.CURRENT_SESSION_ACCOUNT;
import static com.webapp.utils.WebappConstants.ROLE_ADMIN;
import static com.webapp.utils.WebappConstants.ROLE_CUSTOMER;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.webapp.exceptions.InvalidDataException;
import com.webapp.model.Customer;
import com.webapp.services.DataService;
import com.webapp.services.Impl.DataServiceImpl;

@WebServlet("/login.php")
public class LoginController extends AbstractServletHandler {

	static Logger log = Logger.getLogger(LoginController.class.getName());

	private static final long serialVersionUID = 1L;

	private final transient Map<Integer, String> homePages = new HashMap<Integer, String>();

	public LoginController() {

		homePages.put(ROLE_ADMIN, "/admin/home.php");
		homePages.put(ROLE_CUSTOMER, "/customer/home.php");
	}
	
	DataService service =  new DataServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// List<Role> roles = getCommonService().findAllRoles();

		// request.setAttribute("roles", roles);

		gotoToJSP("login.jsp", request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		// Integer role = Integer.parseInt(request.getParameter("role"));

		try {

			Customer customer = service.login(login, password);

			String homePage = homePages.get(customer.getIdRole());

			if (homePage != null) {

				request.getSession().setAttribute(CURRENT_SESSION_ACCOUNT, customer);
				request.getSession().setAttribute("CURRENT_ROLE_ACCOUNT", customer.getIdRole());

				redirectRequest(homePage, request, response);

			} /*
			 * else {
			 * 
			 * throw new InvalidDataException("Unsupported role id " + role); }
			 */

		} catch (InvalidDataException e) {
			log.info("Invalid credentials", e);
			gotoToJSP("login.jsp", request, response);

		}

	}

}
