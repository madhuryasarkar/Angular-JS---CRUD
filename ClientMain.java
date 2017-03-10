package client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import Model.Student;

public class ClientMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Client client=ClientBuilder.newClient();
		WebTarget maintarget=client.target("http://localhost:8080/MyFirstWebProject/rest/");
		
		WebTarget target=maintarget.path("/studentService/readbyStudentId/1");
		Student student=target.request().get(Student.class);
		System.out.println("Student name :"+student.getName());
		
		/*List*/
		
		
		
		
		/*insert*/
		 target=client.target("http://localhost:8080/MyFirstWebProject/rest/").path("/studentService/insert");
		 student.setId(8);
		 Response r=target.request().post(Entity.json(student));
		 System.out.println("response"+r);
		 
		 target=client.target("http://localhost:8080/MyFirstWebProject/rest/").path("/studentService/selectAll");
			List<Student> studentlist=target.request().get(new GenericType<List<Student>>() {});
			for (Student student2 : studentlist) {
				System.out.println("Student NAME:"+student2.getName()+"Student ID"+student2.getId());
			}
	}

}
