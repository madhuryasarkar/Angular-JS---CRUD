package com.Service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

//import org.eclipse.persistence.oxm.MediaType;

import Model.Student;
import DAOs.StudentDAO;

@Path("studentService")
//resource path
public class StudentService {
	
	@POST	
	@Path("/insert")
	@Consumes({"application/json","application/xml"})
	//@Produces(MediaType.APPLICATION_JSON)
	public void insertStudent(Student obj) throws Exception{
		System.out.println("inside service WS");
		StudentDAO sdao = new StudentDAO();
		sdao.insertStudent(obj);
		System.out.println("inside service WS"+obj.getId());
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateStudent(Student obj) throws Exception
	{
		StudentDAO sdao = new StudentDAO();
		sdao.updateStudent(obj);
		//return s;
	}
	
	@DELETE
	@Path("/delete")
	public void deleteStudent(@QueryParam("id")int id) throws Exception
	{
		StudentDAO sdao = new StudentDAO();
		sdao.deleteStudent(id);
		
	}
	/*@GET
	public void test()
	{
		System.out.println("helloooo ferom web service");
	}*/
	
	
	//annotate with each method
	@GET
	@Path("selectAll")
	@Produces(MediaType.APPLICATION_JSON)
	/*@Produces({"application/json","application/xml"})*/
	public List<Student> selectAll() throws Exception
	{
		StudentDAO sdao = new StudentDAO();
		List<Student> l = sdao.selectAll();
		return l;
	}
	
	@GET
	@Path("/studentxml")
	//two get then one has to be specified with path
	@Produces(MediaType.APPLICATION_XML)
	public List<Student> selectAllXML() throws Exception
	{
		StudentDAO sdao = new StudentDAO();
		List<Student> l = sdao.selectAll();
		return l;
	}
	
	/*@GET
	@Path("/readbyStudentId")
	@Produces(MediaType.TEXT_PLAIN)
	public Student readbyStudentId(@DefaultValue("1")@QueryParam("id") int id) throws Exception
	{
		StudentDAO sdao = new StudentDAO();
		Student s=sdao.readbyStudentId(id);
		return s;
	}*/
	
	@GET
	@Path("/readbyStudentId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student readbyStudentId(@PathParam("id") int id) throws Exception
	{
		StudentDAO sdao = new StudentDAO();
		Student s=new Student();
		s.setId(id);
		return s;
	}
	
	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Path("/login")
	public void login(@FormParam("username") String name,@FormParam("password") String password) throws Exception
	{
		System.out.println("usermame "+name +"password "+password);
	}
	
	@POST
	@Path("/getHeader")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHeaderFile(Student obj,@HeaderParam("Content-Type") String contentType,@HeaderParam("name") String contentname){
		System.out.println("Get header"+contentType);
		System.out.println("Get header name"+contentname);
		ResponseBuilder rb=Response.status(Status.OK).entity(obj);
		rb.header("Content-Type", "application/json");
		Cookie newCookie=new Cookie("uname", obj.getName());
		System.out.println("Cookie uname"+newCookie.getValue());
		System.out.println("Cookie domain"+newCookie.getDomain());
		System.out.println("Cookie name"+newCookie.getName());
		System.out.println("Cookie version"+newCookie.getVersion());
		
		
		return rb.build();
		
	}
}
