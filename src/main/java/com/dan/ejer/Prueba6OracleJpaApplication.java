package com.dan.ejer;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Prueba6OracleJpaApplication {

	@Value("${usuario}")
	private String user;
	@Value("${pass}")
	private String pass;
	@Value("${url}")
	private String url;
	
	public static void main(String[] args) {
		SpringApplication.run(Prueba6OracleJpaApplication.class, args);
	}

	@Bean
	public DataSource getDataSource() {
		return DataSourceBuilder.create()
				.url(url)
				.username(user)
				.password(pass)
				.build();			
	}
}
