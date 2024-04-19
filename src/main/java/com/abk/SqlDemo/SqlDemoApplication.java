package com.abk.SqlDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EntityScan
@SpringBootApplication
public class SqlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqlDemoApplication.class, args);
	}

}
