package com.example.mvc_assigment_2_new.config;


import com.example.mvc_assigment_2_new.service.impl.ProjectService_impl;
import com.example.mvc_assigment_2_new.service.impl.TechServiceimpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan
@Import({JpaConfig.class, TechServiceimpl.class, ProjectService_impl.class})
public class WebRootConfig {
    WebRootConfig(){
        System.out.println("hit root");
    }
}
