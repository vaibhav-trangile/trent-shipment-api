package com.tatatrent.wms.db.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.tatatrent.wms.util.AppConstants;

@Configuration
public class JdbcDataSource {
	
	@Value("${oracle.db.host}") 
	private String host;
	
	@Value("${oracle.db.username}") 
	private String username;
	
	@Value("${oracle.db.password}") 
	private String password;
	
	
	@Value("${oracle.db.sid}") 
	private String sid;
	
	
	
	@Bean
	@Primary
	public DataSource dataSource() {
		return DataSourceBuilder
				.create()
				.driverClassName(AppConstants.DRIVER_CLASS)
				.username(username.trim())
				.password(password.trim())
				.url(getUrl())
				.build();
	}

	private String getUrl() {
		StringBuilder strbr = new StringBuilder(AppConstants.DB_PREFIX);
		strbr.append(host.trim()).append(":" + AppConstants.DB_POSTFIX + sid);
		return strbr.toString();
	}

}

