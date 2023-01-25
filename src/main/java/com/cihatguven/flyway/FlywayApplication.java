package com.cihatguven.flyway;

import liquibase.exception.LiquibaseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;

@SpringBootApplication
public class FlywayApplication {

	public static void main(String[] args) throws SQLException, LiquibaseException, IOException, ParserConfigurationException {
		SpringApplication.run(FlywayApplication.class, args);
	}

}
