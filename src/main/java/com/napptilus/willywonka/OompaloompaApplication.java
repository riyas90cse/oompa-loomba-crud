package com.napptilus.willywonka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Mohamed Riyas (riyas90cse@gmail.com)
 * Application Bootstrap
 */
@SpringBootApplication
public class OompaloompaApplication extends SpringBootServletInitializer {

	/**
	 * Servelet Initializer Method
	 * @param application Spring Application Builder
	 * @return Application
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(OompaloompaApplication.class);
	}

	/**
	 * Main Method
	 * @param args argument
	 */
	public static void main(String[] args) {
		SpringApplication.run(OompaloompaApplication.class, args);
	}

}
