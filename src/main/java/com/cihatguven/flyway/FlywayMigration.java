package com.cihatguven.flyway;

import org.flywaydb.core.Flyway;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class FlywayMigration {

    public void migrate(DataSource dataSource, String migrationPath) {
        Flyway flyway = Flyway
                .configure()
                .locations(migrationPath)
                .baselineOnMigrate(true)
                .dataSource(dataSource)
                .load();
        flyway.migrate();
    }

}