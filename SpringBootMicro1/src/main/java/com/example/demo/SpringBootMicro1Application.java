package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootMicro1Application {
	
	private static Menu menu;
	private static Customer customer;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicro1Application.class, args);
	}
	
	@RequestMapping(value="/calculate/{name}/{time}", method=RequestMethod.GET)
	public String calculate(@PathVariable String name, @PathVariable String time){
		int time1 = 0;
		try {
			System.out.println("Customer name .. " +name);
			System.out.println("Time in mins to have dishes .. " + time +" mins");
			time1 = Integer.parseInt(time);
		} catch (NumberFormatException nfe) {
			System.err.println("Pls pass a valid time only without units.." + nfe.getMessage());
		}catch(ArrayIndexOutOfBoundsException oe){
			System.err.println("Input Args are missing.. Usage:- customer name, time in mins." + oe.getMessage());
		}
		menu = new Menu();
		customer = new Customer(name, time1, menu);
		return Output.getOutPut();
	}	
}
