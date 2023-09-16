package com.example.mvc_assigment_2_new.config;


import com.example.mvc_assigment_2_new.repo.TechRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = {TechRepo.class})
@PropertySource("classpath:application.properties")
public class JpaConfig {

    @Autowired
    Environment environment;


    JpaConfig(){
        System.out.println("jpa class hit");
    }


    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter vendor= new HibernateJpaVendorAdapter();
        vendor.setDatabasePlatform(environment.getRequiredProperty("my.app.dialect"));
        vendor.setShowSql(true);
        vendor.setDatabase(Database.MYSQL);
        vendor.setGenerateDdl(true);
        return  vendor;
    }


    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
        driverManagerDataSource.setUrl(environment.getRequiredProperty("my.app.url"));
        driverManagerDataSource.setDriverClassName(environment.getRequiredProperty("my.app.driverclassname"));
        driverManagerDataSource.setUsername(environment.getRequiredProperty("my.app.username"));
        driverManagerDataSource.setPassword(environment.getRequiredProperty("my.app.password"));
        return driverManagerDataSource;
    }



    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter){
        LocalContainerEntityManagerFactoryBean bean=new LocalContainerEntityManagerFactoryBean();
        bean.setJpaVendorAdapter(jpaVendorAdapter);
        bean.setDataSource(dataSource);
        bean.setPackagesToScan("com/example/mvc_assigment_2_new/entity");
        return bean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }



}
