package com.mzyan.Springboot01helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication 来标注一个主程序，说明这是一个SpringBoot应用
 */
@SpringBootApplication
public class SpringBoot01HelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot01HelloworldApplication.class, args);
	}

}
