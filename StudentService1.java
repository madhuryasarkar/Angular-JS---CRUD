package com.Service;

import java.util.ArrayList;
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



import Model.Student;

//resource path
@Path("/studentWeb")
public class StudentService1 {

	private static List<Student> studentList =  new ArrayList<Student>();


	//insert method for our JSON
	//http://localhost:8080/MyWebServices/rest/studentWeb/insertStudentJSON
	//set the header content type to header
	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/insertStudentJSON")
	public void insertJSON(Student obj) 
	{
		//insertStudent();//3 student objects get loaded with this method
		System.out.println("obj "+obj);
		System.out.println("before JSON insert , the list size is:"+studentList.size());
		studentList.add(obj);
		System.out.println("after we insert our JSON :"+studentList.size());
	}

	
	//method to retrieve the data	
	//URL to use:: http://localhost:8080/MyWebServices/rest/studentWeb/studentJSON
	@GET
	@Path("/studentJSON")
	@Produces(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_XML)// to get data in XML format
	public List<Student> selectAllXML() 
	{
		//insertStudent();//3 student objects get loaded with this method
		System.out.println("inside selectAllXML  "+studentList.size());
		return studentList;
	}


	//searchMethod which reads the list and returns an object based on the id sent in the path
	//http://localhost:8080/MyWebServices/rest/studentWeb/id/123
	@GET
	@Path("/search/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student readbyStudentId(@PathParam("id") int id) 
	{
		System.out.println("inside readStudentbyId and Id passed is :"+id);
		//insertStudent();//3 student objects get loaded with this method
		Student s = null;
		for (Student student : studentList) {
			if(id==student.getId())
			{
				s = student;
			}
		}
		return s;

	}


	//method to delete a record based on URL
	//URL to use:: http://localhost:8080/MyWebServices/rest/studentWeb/delete?id=123
	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteStudent(@QueryParam("id") int id) throws Exception
	{
		System.out.println("inside delete and Id passed is :"+id);
		//insertStudent();//3 student objects get loaded with this method
		//List<Student> deleteList = new ArrayList<Student>();

		for (Student student : studentList) 
		{
			if(id==student.getId())
			{
				studentList.remove(student);
				break;
			}
		}

	}


	
	//method to update a student record based on id
	//URL to use:http://localhost:8080/MyWebServices/rest/studentWeb/update
	@POST
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public void updateName(Student obj)
	{
		System.out.println("inside update and Id passed is :"+obj.getId());
		//insertStudent();//3 student objects get loaded with this method

		for (Student student : studentList) {
			if(obj.getId()==student.getId())
			{
				student.setName(obj.getName());
				student.setMarks(obj.getMarks());
				student.setAge(obj.getAge());
			}
		}
		
	}

}
