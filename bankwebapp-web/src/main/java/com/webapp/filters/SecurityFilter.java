package com.webapp.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webapp.model.Customer;
import com.webapp.utils.WebappConstants;

@WebFilter(filterName = "securityFilter")
public class SecurityFilter extends AbstractWebappFilter {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpSession session = request.getSession();
		String uri = request.getRequestURI();

		if (uri.equals("/webappm/index.jsp") || uri.equals("/webappm/login.php")) {
			chain.doFilter(request, response);
			return;
		}

		Customer ob = (Customer) session.getAttribute(WebappConstants.CURRENT_SESSION_ACCOUNT);

		if (ob != null) {
			chain.doFilter(request, response);
			return;
		}

		response.sendRedirect((request.getContextPath() + "/index.jsp"));
		return;

	}
}
