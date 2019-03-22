package com.analog.employeesystemallocation.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.analog.employeesystemallocation.*"})
@EnableJpaRepositories({"com.analog.employeesystemallocation.repository"})
@EnableJpaAuditing
@EnableTransactionManagement
@EntityScan({"com.analog.employeesystemallocation.model"})
@EnableScheduling
@SpringBootApplication
//public class App {
//	
//	private static final Logger logger = LoggerFactory.getLogger(App.class);
//	
//	public static void main(String[] args) {
//		logger.info("App controller main method");
//		SpringApplication.run(App.class,args);
//	}
//}
public class App  extends SpringBootServletInitializer {
	
	private static final Logger logger = LoggerFactory.getLogger(App.class);
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(App.class);
	}
	
	public static void main(String[] args) {
		logger.info("App controller main method");
		SpringApplication.run(App.class,args);
	}

}

