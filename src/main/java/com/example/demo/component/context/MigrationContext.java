package com.example.demo.component.context;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.ClassicConfiguration;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class MigrationContext {
    @Bean
    @ConfigurationProperties("flyway.wl")
    public ClassicConfiguration wlFlywayConfiguration() {
        return new ClassicConfiguration();
    }

    @Bean(initMethod = "migrate")
    @FlywayDataSource
    @Primary
    public Flyway wlFlyway(ClassicConfiguration wlFlywayConfiguration, DataSource wlGlobalDataSource) {
        return new Flyway(
                new FluentConfiguration().configuration(wlFlywayConfiguration).dataSource(wlGlobalDataSource));
    }
}
