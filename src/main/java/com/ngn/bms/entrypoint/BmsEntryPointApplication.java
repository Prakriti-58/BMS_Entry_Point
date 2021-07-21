package com.ngn.bms.entrypoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class BmsEntryPointApplication {

	public static void main(String[] args) {
		SpringApplication.run(BmsEntryPointApplication.class, args);
	}

}
