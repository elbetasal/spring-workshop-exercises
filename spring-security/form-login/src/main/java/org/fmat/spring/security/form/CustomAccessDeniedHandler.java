package org.fmat.spring.security.form;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest httpServletRequest,
	                   HttpServletResponse httpServletResponse,
	                   AccessDeniedException e) throws IOException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication != null) {
			log.error("User tried to login {} while attempted to access URL {}",
					authentication.getName(), httpServletRequest.getRequestURI());
		}
		httpServletResponse.sendRedirect(httpServletRequest.getContextPath() +"/accessDenied.html");
	}
}
