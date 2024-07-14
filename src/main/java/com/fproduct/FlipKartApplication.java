package com.fproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.fproduct")
@EnableEurekaClient
@EnableSwagger2
public class FlipKartApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlipKartApplication.class, args);
	}

}
