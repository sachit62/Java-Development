package com.example.myApp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class MyApp2Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(MyApp2Application.class, args);

		Dev obj = context.getBean(Dev.class);
		obj.build();


	}

}
