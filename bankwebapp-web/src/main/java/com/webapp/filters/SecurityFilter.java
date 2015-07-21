package com.webapp.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webapp.model.Customer;
import com.webapp.utils.WebappConstants;

@WebFilter(filterName = "securityFilter")
public class SecurityFilter implements Filter {

	/*
	 * public void doFilter(HttpServletRequest request, HttpServletResponse
	 * response, FilterChain chain) throws IOException, ServletException {
	 * 
	 * HttpSession session = request.getSession(); String uri =
	 * request.getRequestURI();
	 * 
	 * if (uri.equals("/webappm/index.jsp") || uri.equals("/webappm/login.php"))
	 * { chain.doFilter(request, response); return; }
	 * 
	 * Customer ob = (Customer)
	 * session.getAttribute(WebappConstants.CURRENT_SESSION_ACCOUNT);
	 * 
	 * if (ob != null) { chain.doFilter(request, response); return; }
	 * 
	 * response.sendRedirect((request.getContextPath() + "/index.jsp")); return;
	 * 
	 * }
	 */

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		String uri = ((HttpServletRequest) request).getRequestURI();

		if (uri.endsWith("/webappm/index.jsp") || uri.equals("/webappm/login.php")) {
			chain.doFilter(request, response);
			return;
		}

		Customer ob = (Customer) session.getAttribute(WebappConstants.CURRENT_SESSION_ACCOUNT);

		if (ob != null) {
			chain.doFilter(request, response);
			return;
		}

		((HttpServletResponse) response).sendRedirect((((HttpServletRequest) request).getContextPath() + "/index.jsp"));
		return;

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
}
