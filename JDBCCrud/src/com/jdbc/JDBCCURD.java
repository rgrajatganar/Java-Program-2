package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class JDBCCURD 
{
	public void create() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch7293","root","root");
		PreparedStatement pstmt = con.prepareStatement("CREATE TABLE Employee (eid INT AUTO_INCREMENT PRIMARY KEY, ename VARCHAR(50), age int, gender VARCHAR(50), dept VARCHAR(50) ,salary int)");
		int result = pstmt.executeUpdate();

		if (result == 0) 
		{
			System.out.println("Table is Created...!!!");
		} 
		else 
		{
			System.out.println("Table already exists...!!!");
		}
	}
	
	public void insert() throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch7293","root","root");
		PreparedStatement pstmt = con.prepareStatement("insert into Employee values(?,?,?,?,?,?)");
		int id;
		String name;
		int age;
		String gender,dept;
		int salary;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Insert Employee Details");
		
		System.out.println("Enter Employee Id : ");
		id=sc.nextInt();
		
		System.out.println("Enter Employee Name : ");
		name=sc.next();
		
		System.out.println("Enter Employee Age : ");
		age=sc.nextInt();
		
		System.out.println("Enter Employee Gender : ");
		gender=sc.next();
		
		System.out.println("Enter Employee dept : ");
		dept=sc.next();
		
		System.out.println("Enter Employee Salary : ");
		salary=sc.nextInt();
		
		pstmt.setInt(1,id);
		pstmt.setString(2, name);
		pstmt.setInt(3,age);
		pstmt.setString(4, gender);
		pstmt.setString(5, dept);
		pstmt.setInt(6,salary);
		
		int i = pstmt.executeUpdate();
		System.out.println(i +" Employee Data Added");
		con.close();
	}

	public void update() throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch7293","root","root");
		PreparedStatement pstmt = con.prepareStatement("update Employee set ename=?,age=?,gender=?,dept=?,salary=? where eid = ?");
		int id;
		String name;
		int age;
		String gender,dept;
		int salary;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Update Employee Details");
		
		System.out.println("Enter Employee Id : ");
		id=sc.nextInt();
		
		System.out.println("Enter Employee Name : ");
		name=sc.next();
		
		System.out.println("Enter Employee Age : ");
		age=sc.nextInt();
		
		System.out.println("Enter Employee Gender : ");
		gender=sc.next();
		
		System.out.println("Enter Employee dept : ");
		dept=sc.next();
		
		System.out.println("Enter Employee Salary : ");
		salary=sc.nextInt();
		
		pstmt.setInt(6,id);
		pstmt.setString(1, name);
		pstmt.setInt(2,age);
		pstmt.setString(3, gender);
		pstmt.setString(4, dept);
		pstmt.setInt(5,salary);
		
		int i = pstmt.executeUpdate();
		System.out.println(i+"Employee Data Updated");
		con.close();
	}
	public void delete() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch7293","root","root");
		PreparedStatement ps = con.prepareStatement("delete from Employee where eid=?");
		int id;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Delete Employee Details");
		
		System.out.println("Enter Employee Id : ");
		id=sc.nextInt();
		
		ps.setInt(1, id);
		
		int i = ps.executeUpdate();
		con.close();
		System.out.println(i+"Employee Data Deleted");
		
	}
	public void salary() throws ClassNotFoundException, SQLException
	{
		 Class.forName("com.mysql.cj.jdbc.Driver");
		
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/batch7293","root","root");

		 Statement stmt = con.createStatement();
		 
		 System.out.println("Employee details are:");
		 
		 ResultSet rs = stmt.executeQuery("select * from Employee where salary > 25000");	//executeQuery return type is resultSet
			
		 int id;
			String name;
			int age;
			String gender,dept;
			int salary;
			
		 System.out.println("Employee Details: ");
		 System.out.println("==================");
			
		 while(rs.next())
		 {
		    id = rs.getInt(1);
			name = rs.getString(2);
			age = rs.getInt(3);
			gender = rs.getString(4);
			dept = rs.getString(5);	
			salary = rs.getInt(6);	
				
			System.out.println(id+ " " +name+ " " +age+ " " +gender+ " " +dept+""+salary);
				
		}
		
		 con.close();
	}
	
	public void exit()
	{
		System.out.println("Please Enter Valid Input...!!!");
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		
		Scanner sc = new Scanner(System.in);
		JDBCCURD jdbc = new JDBCCURD();
		
		while(true)
		{
			System.out.println("Choose any Option: 1.Create  2.Insert  3.Update  4.Delete 5.Salary 6.Exit");
			int ch = sc.nextInt();
		
		
		switch(ch)
		{
			case 1: 
				jdbc.create();
				break;
				
			case 2:
				jdbc.insert();
				break;
				
			case 3:
				jdbc.update();
				break;
				
			case 4:
				jdbc.delete();
				break;
				
			case 5:
				jdbc.salary();
				break;
				
			case 6:
				jdbc.exit();
				break;
			default:
				System.out.println("Your Option is wrong");
				break;
			
		}
		
		}

	}

}