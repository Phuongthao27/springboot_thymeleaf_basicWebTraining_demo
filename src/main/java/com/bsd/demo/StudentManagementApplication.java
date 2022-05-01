package com.bsd.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.FileReader;

@SpringBootApplication
public class StudentManagementApplication {

	public static void main(String[] args) throws Exception  {

		SpringApplication.run(StudentManagementApplication.class, args);

	}

}
