package com.sinaif.hoover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

@EnableAutoConfiguration
@SpringBootApplication
@ImportResource({"classpath:config/spring-data-mysql.xml","classpath:config/spring-app-mvc.xml"}) // 导入xml配置项
public class AppWebApplication extends SpringBootServletInitializer {

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(AppWebApplication.class);
//	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(AppWebApplication.class);
	}


	public static void main(String[] args) {
		
		SpringApplication.run(AppWebApplication.class, args);
	}



}
