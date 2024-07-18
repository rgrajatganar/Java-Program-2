package com.anudip.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Programming language ...... data maintain
 * java (JDBC API) Application 
 * programming interface.... database
 * 
 */
public class MyFirstJDBCDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		//step 1. register the driver
		//I am using Mysql database i need to install my sql database
		//when i will register the driver i need mysql deriver
		//required the URL of Mysql which i install in my system
		
		//jdbc:mysql://localhost:3306/mydb
		
		//required username and password 
		
// step1:	register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
//step2: establish connection to mysql
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch7293","root","root");
		
//step3: creating statement
		
		Statement stmt=con.createStatement();
		
		stmt.executeUpdate("insert into emp values(3,'Divya', 'Relationship Manager', 'Finance', 4000000)");
		System.out.println("Employee add huaa");
		con.close();
	}
}
