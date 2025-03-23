package com.blueAnt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication 
public class BlueAnt {

	public static void main(String[] args) {
		SpringApplication.run(BlueAnt.class, args);
	}

}
