package Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
	
	private int id;
	private String name;
	private int marks;
	private int age;
	
	/*@Override
	public int compareTo(Object obj) {
		// TODO Auto-generated method stub
		Student student=(Student)obj;
		//System.out.println("inside comparator");
		//System.out.println("Current object :"+this);
		//System.out.println("Other object : "+student);
		if(this.id==student.getId())
		{
			return 0;
		}else if(this.id > student.getId())
		{
			return 1;
		}else
		{
			return -1;
		}

	}*/
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	

}
