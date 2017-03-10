package DAOs;

import java.sql.*;

public class PeriDAO {
	
	private static Connection con;
	
	private PeriDAO() throws ClassNotFoundException, SQLException
	{
		System.out.println("Private constructor");
		Class.forName("com.mysql.jdbc.Driver");
		//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","peri123");
	}
	
	public static Connection DBConnection() throws  SQLException, ClassNotFoundException
	{
		System.out.println("Method of singleton");
		PeriDAO p =new PeriDAO();
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanager","root","root");
		if(con == null)
		{
			System.out.println("Con is null");
		}
		else
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanager","root","root");
		}
		return con;
	}

}
