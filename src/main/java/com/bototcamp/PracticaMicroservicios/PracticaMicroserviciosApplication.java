package com.bototcamp.PracticaMicroservicios;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bototcamp.PracticaMicroservicios.PatronBuilder.Usuario;
import com.bototcamp.PracticaMicroservicios.PatronBuilder.UsuarioBuilder;
import com.bototcamp.PracticaMicroservicios.PatronSingleton.UsuarioSingleton;


public class PracticaMicroserviciosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PracticaMicroserviciosApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {	
		Usuario u = new UsuarioBuilder().email("prueba@gmail.com").nombre("Nombbe").telefono("654312312").direccion("Calle falsa 123").build();
		
		System.out.println(u);
		
		UsuarioSingleton s = UsuarioSingleton.getSingletonInstance("Nombre1", "Email1", "Direccion1", "Telefono1");
		System.out.println(s);
		UsuarioSingleton s2 = UsuarioSingleton.getSingletonInstance("Nombre1", "Email1", "Direccion1", "Telefono1");
		
		System.out.println(s.hashCode());
		System.out.println(s2.hashCode());

		UsuarioSingleton.deleteInstance();
		UsuarioSingleton s3 = UsuarioSingleton.getSingletonInstance("Nombre1", "Email1", "Direccion1", "Telefono1");
		UsuarioSingleton s4 = UsuarioSingleton.getSingletonInstance("Nombre1", "Email1", "Direccion1", "Telefono1");
		
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());

	}

}
