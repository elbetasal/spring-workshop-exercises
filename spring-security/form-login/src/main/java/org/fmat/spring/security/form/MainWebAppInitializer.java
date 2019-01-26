package org.fmat.spring.security.form;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class MainWebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext sc) {
		AnnotationConfigWebApplicationContext root =
				new AnnotationConfigWebApplicationContext();

		root.scan("org.fmat.spring.security.form");
		sc.addListener(new ContextLoaderListener(root));

		ServletRegistration.Dynamic appServlet =
				sc.addServlet("mvc", new DispatcherServlet(new GenericWebApplicationContext()));
		appServlet.setLoadOnStartup(1);

		sc.addFilter("securityFilter", new DelegatingFilterProxy("springSecurityFilterChain"))
				.addMappingForUrlPatterns(null, false, "/*");
		appServlet.addMapping("/");
	}
}
