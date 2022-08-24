package com.UdeA.Ciclo3;

import com.UdeA.Ciclo3.Modelos.Empresa;
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

	@GetMapping("/test")	//Al entrar a la ruta http://localhost:8080/test se ejecuta lo siguiente:
	public String test(){
		Empresa emp = new Empresa("Solar SAS", "Calle la geta", "3123123123","800212132-3");
		System.out.println("Se creó la empresa");	//Banderita
		emp.setNombre("Solar Ltda");	//Así cambiamos el nombre de la empresa.
		System.out.println("Se cambió el nombre de la empresa");	//Banderita
		return emp.getNombre();
	}

	public static void main(String[] args) {
		SpringApplication.run(Ciclo3Application.class, args);
	}

}
