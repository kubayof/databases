package com.naofi;

import com.naofi.model.DataGenerator;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@SpringBootApplication
@EnableWebMvc
public class Startup {
    public static void main(String[] args) {
        SpringApplication.run(Startup.class, args);
    }

    @Bean
    public SessionFactory sessionFactory() {
        return new Configuration().configure()
                .buildSessionFactory();
    }

    @Bean
    @Scope("prototype")
    public DataSource ds() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl("jdbc:postgresql://localhost:5432/db_labs");
        ds.setUsername("test");
        ds.setPassword("testpass");
        ds.setDriverClassName("org.postgresql.Driver");

        return ds;
    }
}
