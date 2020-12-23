package com.myroutine.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(
  urlPatterns = {"/*"}
)
public class MyRoutineSecurityFilter implements Filter {
	
	private final static String[] authURLs = {
			"/admin/",
//			"/member/login",
	};

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
//		request.getRequestURI()
//		request.getRequestURL()
		
		String uri = request.getRequestURI();
		
		HttpSession session = request.getSession();
		
		boolean requireAuth = false;
		for(String authUrl : authURLs)
			if(uri.contains(authUrl)) {
				requireAuth = true;
				break;
			}
		
		if( requireAuth ) {
			if( session.getAttribute("memberId") == null ) {
				response.sendRedirect("/account/login?return-url=" + uri);
				return;
			}
			int rule = (int)session.getAttribute("rule");
			if( rule != 9) {
				response.setStatus(403);
				request.getRequestDispatcher("/error/403.html").forward(request, response);
				return;
			}
		}

		chain.doFilter(request, response);
	}

}
