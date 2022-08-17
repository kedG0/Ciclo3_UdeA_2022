package com.UdeA.Ciclo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
public class Ciclo3Application {

	@GetMapping("/hello")	//Al entrar a la ruta http://localhost:8080/hello se ejecuta lo siguiente:
	public String hello(){
		return "Hola ciclo 3. Este es el primer print en web";
	}

	public static void main(String[] args) {
		SpringApplication.run(Ciclo3Application.class, args);
	}

}
