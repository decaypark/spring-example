package com.mig.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties
public class DataSourceProperties {

    @Primary
    @Bean(name="asisDataSource")
    @Qualifier("asisDataSource")
    @ConfigurationProperties(prefix="spring.datasource.hikari.asis")
    public DataSource asisDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name="asisTxManager")
    @Qualifier("asisTxManager")
    public PlatformTransactionManager asisTxManager(@Qualifier("asisDataSource") DataSource asisDataSource) {
        return new DataSourceTransactionManager(asisDataSource);
    }

    @Bean(name="tobeDataSource")
    @Qualifier("tobeDataSource")
    @ConfigurationProperties(prefix="spring.datasource.hikari.tobe")
    public DataSource tobeDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name="tobeTxManager")
    @Qualifier("tobeTxManager")
    public PlatformTransactionManager tobeTxManager(@Qualifier("tobeDataSource") DataSource tobeDataSource) {
        return new DataSourceTransactionManager(tobeDataSource);
    }

    @Bean(name = "tobeJdbcDataSource")
    @Autowired
    public JdbcTemplate tobeJdbcTemplate(@Qualifier("tobeDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


    @Bean(name = "asisJdbcDataSource")
    @Autowired
    public JdbcTemplate asisJdbcTemplate(@Qualifier("asisDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
