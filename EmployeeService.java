package com.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("employeeService")
public class EmployeeService {

	
	@Path("/addEmployee")
	@GET
	public void addEmployee(){
		System.out.println("insed employee");
		
		System.out.println("erroe"+(5/0));
	}
}
