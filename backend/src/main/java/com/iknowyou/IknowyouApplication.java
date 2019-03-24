package com.iknowyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class IknowyouApplication {

	public static void main(final String[] args) {
		SpringApplication.run(IknowyouApplication.class, args);
	}

}
