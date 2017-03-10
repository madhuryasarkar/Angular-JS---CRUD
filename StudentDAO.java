package DAOs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Model.Student;

public class StudentDAO {
	
	/*Connection con=null;
	
	public void DBConnection() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","peri123");
	}*/
	
	
	public void insertStudent(Student obj) throws Exception
	{
		Connection con = PeriDAO.DBConnection();
		System.out.println("Reached insert of Dao");
		String name= obj.getName();
		int id= obj.getId();
		int age = obj.getAge();
		int marks = obj.getMarks();
		System.out.println(marks);
		//DBConnection();
		PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?)");
		ps.setString(4, name);
		ps.setInt(1, id);
		ps.setInt(3, marks);
		ps.setInt(2, age);
		ps.executeUpdate();
		
		con.close();
	}
	
	public void deleteStudent(int id) throws Exception
	{
		Connection con = PeriDAO.DBConnection();
		Statement statement = con.createStatement();
		String sql="delete from student where id="+id;
		statement.execute(sql);
		System.out.println("Successfully Deleted");
		
		con.close();
	}
	
	public void updateStudent(Student obj) throws Exception
	{
		Connection con = PeriDAO.DBConnection();
		PreparedStatement ps = con.prepareStatement("update student set name=?, age=?,marks=? where id =? ");
		ps.setString(1,obj.getName());
		ps.setInt(2,obj.getAge());	
		ps.setInt(3,obj.getMarks());
		ps.setInt(4,obj.getId());
		
		ps.executeUpdate();
		
		con.close();
	
		System.out.println("Successfully updated");
	}
	
	public Student readbyStudentId(int id) throws Exception
	{
		Connection con = PeriDAO.DBConnection();
		Statement statement = con.createStatement();
		System.out.println("inside readbystudnetId");
		String sql="select * from student where id="+id;
		//ps.setString(2, name);
		//ps.setInt(1, id);
		Student s = new Student();
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next())
		{
			
			s.setId(rs.getInt(1));
			s.setName(rs.getString(4));
			s.setMarks(rs.getInt(3));
			s.setAge(rs.getInt(2));
			//studentList.add(s);		
		}
		
		
		con.close();
		return s;
	}
	
	
	/*public List<Student> highestMarks() throws Exception
	{
		DBConnection();
		Statement statement = con.createStatement();
		String sql="select * from student order by marks desc ";
		ResultSet rs = statement.executeQuery(sql);
		List<Student> studentList = new ArrayList<Student>();
		Student s=null;
		while(rs.next())
		{
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setMarks(rs.getInt(3));
			s.setAge(rs.getInt(4));
			studentList.add(s);		
		}
		
		return studentList;
	}*/
	
	
	
	public List<Student> selectAll() throws Exception
	{
		Connection con = PeriDAO.DBConnection();
		Statement statement = con.createStatement();
		String sql="select * from student";
		ResultSet rs = statement.executeQuery(sql);
		List<Student> studentList = new ArrayList<Student>();
		
		System.out.println("reached select All in DAO");
		
		while(rs.next())
		{
			Student s=new Student();

			s.setId(rs.getInt(1));
			s.setName(rs.getString(4));
			s.setMarks(rs.getInt(3));
			s.setAge(rs.getInt(2));
			
			/*System.out.println(s.getId());
			System.out.println(s.getName());
			System.out.println(s.getMarks());
			System.out.println(s.getAge());*/
			studentList.add(s);		
		}
		con.close();
		return studentList;
		
	}
	
	

}
