package com.pe.nimhans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class NimhansApplication {

	public static void main(String[] args) {
		SpringApplication.run(NimhansApplication.class, args);
	}  

}
