package com.example.demo.component.context;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JdbcContext {
    public JdbcContext() {
        //
    }

    @ConfigurationProperties("jdbc.wldb")
    public DataSource wlGlobalDataSource() {
        return new HikariDataSource();
    }
}
