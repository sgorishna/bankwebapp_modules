package com.webapp.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.model.Customer;

import static com.webapp.utils.WebappConstants.CURRENT_SESSION_ACCOUNT;



@WebFilter(filterName = "securityFilter")
public class SecurityFilter extends AbstractWebappFilter {

	
	String [] pages = {"/login.php", "/signUp.php", "/checkLogin", "/checkEmail",  "/RemindCredentials", "/image", "/verify" };
	
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

		String servletPath = request.getServletPath();
		
		for(int i = 0; i<pages.length; i++){
			
			if (servletPath.equals(pages[i])) {
				chain.doFilter(request, response);
				return;
			}
		}
		

		Customer currentAccount = (Customer) request.getSession().getAttribute(CURRENT_SESSION_ACCOUNT);

		if (currentAccount != null) {

			chain.doFilter(request, response);
			return;
		}

		response.sendRedirect(request.getServletContext().getContextPath() + "/login.php");
	}


	
	
}
