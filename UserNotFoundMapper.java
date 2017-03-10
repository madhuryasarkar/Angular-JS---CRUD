package com.Service;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.spi.ExceptionMappers;


@Provider
public class UserNotFoundMapper implements ExceptionMapper<ArithmeticException>{

	@Override
	public Response toResponse(ArithmeticException ex) {
		// TODO Auto-generated method stub
		System.out.println(ex.getMessage());
		return Response.status(500).entity(ex.getMessage()).type("text/plain").build();
	}

}
