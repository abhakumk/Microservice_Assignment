package com.ms.assignment.ConvertCurrencyMs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author w2cluster03
 *
 */
@SpringBootApplication
@EnableSwagger2
@EnableFeignClients
public class ConvertCurrencyMsApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConvertCurrencyMsApplication.class, args);
	}

}
