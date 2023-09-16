package com.example.mvc_assigment_2_new.config;


import com.example.mvc_assigment_2_new.Res.ResponseController;
import com.example.mvc_assigment_2_new.controller.TechController;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {TechController.class, ResponseController.class})
public class WebAppConfig {


    WebAppConfig(){
        System.out.println("hit web app config");
    }


    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
