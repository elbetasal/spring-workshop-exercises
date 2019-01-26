package org.fmat.spring.security.form;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class DatabaseConfig {

	@Value("${jdbc.app.password}")
	private String sqluserpassword ;

	@Value("${jdbc.app.username}")
	private String username;

	@Value("${jdbc.app.driver}")
	private String driver;

	@Value("${jdbc.app.url}")
	private String url;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(driver);
		driverManagerDataSource.setUrl(url);
		driverManagerDataSource.setUsername(username);
		driverManagerDataSource.setPassword(sqluserpassword);
		return driverManagerDataSource;

	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertPlaceHolderConfiguer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
