package com.cihatguven.flyway;

import liquibase.exception.LiquibaseException;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.SQLException;
@Slf4j
@SpringBootTest
class FlywayApplicationTests {

	@Autowired
	FlywayMigration flywayMigration;

	@Test
	void contextLoads() {
	}

	@Test
	public void diffTest(){
		try {
			LiquiBaseDiffAsSql.diff();
		} catch (LiquibaseException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (ParserConfigurationException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	@Test
//	@Ignore
	public void migateTest() throws SQLException {
		MariaDbDataSource dataSource = new MariaDbDataSource("localhost",3306, "empty_country");
		dataSource.setUser("root");
		dataSource.setPassword("12345");
		flywayMigration.migrate(dataSource, "db/migration");


	}


}
