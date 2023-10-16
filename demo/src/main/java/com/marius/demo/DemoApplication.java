package com.marius.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;


/**
 * Main class of Spring applications.
 * Meaning of annotations used:
 *      - SpringBootApplication: standard annotation for Spring Boot apps
 *      - ConfigurationPropertiesScan: configures the base packages used
 *        when scanning for classes that uses '@ConfigurationProperties' annotation.
 *        his annotation allows us to map properties from configuration file
 *        to Java POJOs
 *
 */
@SpringBootApplication
@ConfigurationPropertiesScan
public class DemoApplication {

	/**
	 * Main method of application that constitutes the entry point
	 * of the application
	 * @param args Arguments used in application
	 */
	public static void main(String[] args) {
		new SpringApplicationBuilder(DemoApplication.class)
				.run(args);
	}

}
