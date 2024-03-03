package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Vehicle;

@SpringBootApplication
public class BootProj02DependencyInjectionApplication {

	public static void main(String[] args) {
		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootProj02DependencyInjectionApplication.class, args);
		//get access to target spring bean class object
		Vehicle vehicle = ctx.getBean("vehicle",Vehicle.class);
		//invoke the b.method
		vehicle.journey("Hyderabad", "Ayodhya");
		
		//clode the IOC Container
		((ConfigurableApplicationContext) ctx).close();
	}

}
