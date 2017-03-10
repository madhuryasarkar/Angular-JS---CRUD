package DAOs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

import Model.Student;

public class StudentManagementSystem {
	
	
	
	StudentDAO sdao=new StudentDAO();

	public StudentManagementSystem() {
		// TODO Auto-generated constructor stub();
		
	}
	
	void enrollment(int id,String name,int marks,int age,Student obj) throws Exception
	{
		//Student obj = new Student();
		obj.setId(id);
		obj.setName(name);
		obj.setAge(age);
		obj.setMarks(marks);
		sdao.insertStudent(obj);
		
	}
	
	void search(int id) throws Exception
	{
		System.out.println("inside sms search");
		sdao.readbyStudentId(id);
	}
	
	
	void remove(int id) throws Exception
	{
		
		sdao.deleteStudent(id);
	}
	
	void printAll() throws Exception
	{
					
		List<Student> studentList =sdao.selectAll();
		Iterator i = studentList.iterator();
		Student s;
		while(i.hasNext())
		{
			s=(Student) i.next();
			System.out.println(s.getId()+" ,"+s.getName());
		}
	}

	void updateStudent(int id,String name,int age,int marks, Student obj) throws Exception
	{
		obj.setId(id);
		obj.setName(name);
		obj.setAge(age);
		obj.setMarks(marks);
		//sdao.insertStudent(obj);
		sdao.updateStudent(obj);
	}
	
	public static void main(String[] args) throws Exception {
		
		StudentManagementSystem sm = new StudentManagementSystem();
		
		/*Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		sm.enrollment(123, "keerthana", 345, 24,s1);
		sm.enrollment(345, "Harshada", 457, 24,s2);
		sm.enrollment(256, "Akanksha", 456, 26,s3);
		//sm.printAll();
		//sm.search(123);
		//sm.remove(123);
		//sm.printStudentDetailByHighestMark();*/
		
		
		System.out.println("Enter 1- enrollment "
				+ "2-search "
				+ "3- remove "
				+ "4-printall "
				+ "5-update "
				+ "6-exit");
		
		@SuppressWarnings("resource")
		Scanner sc =new Scanner(System.in);
		int n=0;
		
		while(n<6)
		{
			System.out.println("Enter your input");
			n= sc.nextInt();
			switch (n) {
			case 1:
				
				int id=0,marks=0,age=0;
				String name;
				System.out.println("Enter name :");
				name= sc.next();
				System.out.println("Enter Id");
				id=sc.nextInt();
				System.out.println("Enter age");
				age=sc.nextInt();
				System.out.println("Enter marks");
				marks=sc.nextInt();
				Student s1= new Student();
				sm.enrollment(id, name, marks, age,s1);
				break;

			case 2:
				
				int id1=0;
				System.out.println("Enter Id");
				id1=sc.nextInt();
				sm.search(id1);
				break;
				
			case 3:
				
				int id2=0;
				System.out.println("Enter Id");
				id2=sc.nextInt();
				sm.remove(id2);
				break;
				
			case 4:
				
				sm.printAll();
				break;
				
			case 5:
				int id3=0,marks1=0,age1=0;
				String name1;
				
				System.out.println("Enter Id of the student to update the details");
				id3=sc.nextInt();
				System.out.println("Enter name :");
				name1= sc.next();
				System.out.println("Enter age");
				age1=sc.nextInt();
				System.out.println("Enter marks");
				marks1=sc.nextInt();
				Student s2= new Student();
				//sm.enrollment();
				sm.updateStudent(id3, name1, marks1, age1,s2);
				break;
			case 6:
				break;
			default:
				break;
			}
		}
		
		
	}
}
