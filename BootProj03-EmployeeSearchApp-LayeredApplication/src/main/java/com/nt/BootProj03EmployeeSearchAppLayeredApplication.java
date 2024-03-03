package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.PayrollOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProj03EmployeeSearchAppLayeredApplication {

	public static void main(String[] args) {
		//get IOC Container
		ApplicationContext ctx=SpringApplication.run(BootProj03EmployeeSearchAppLayeredApplication.class, args);
		//get controller class object ref
		PayrollOperationsController controller = ctx.getBean("payroll",PayrollOperationsController.class);
		
		//invoke the b. method
		try {
			List<Employee> list= controller.showEmployeesByDesgs("CLERK", "MANAGER", "SALESMAN");
			list.forEach(emp->{
				System.out.println(emp);
			});
		}//try
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("Internal problem --try again::"+e.getMessage());
			
		}//catch
		//close IOC container
		((ConfigurableApplicationContext)  ctx).close();
	}//main

}//class
