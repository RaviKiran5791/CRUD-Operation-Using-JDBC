package com.jsp.student_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDAO 
{
	
	public static void savaStudent()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Student Name: ");
		String name=sc.nextLine();
		System.out.println("Enter Student Email: ");
		String email=sc.nextLine();
		System.out.println("Enter Student Id: ");
		int id=sc.nextInt();
		System.out.println("Enter Student Marks: ");
		int marks=sc.nextInt();
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
				PreparedStatement pstmt = con.prepareStatement("insert into studentdb.student values(?,?,?,?)");
				
				pstmt.setInt(1, id);
				pstmt.setString(2, name);
				pstmt.setString(3, email);
				pstmt.setInt(4, marks);
				
				int result = pstmt.executeUpdate();
				
				System.out.println(result+" records inserted");
				
				pstmt.close();
				con.close();		
				
			} 
			catch (Exception e) {
				e.printStackTrace();
			}			
	}
	
	public static void getStudentById()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Student id");
		int id=sc.nextInt();
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
			PreparedStatement pstmt = con.prepareStatement("Select * from studentdb.student where studentId=?");
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			
			while(rs.next())
			{
				String name=rs.getString("studentName");
				String email=rs.getString("studentEmail");
				int marks=rs.getInt("studentMarks");
				
//				System.out.println(id+" "+name+" "+email+" "+marks);
				System.out.printf("%-5d %-10s %-20s %4d%n", id, name, email, marks);			}
			
			rs.close();pstmt.close();con.close();
			
		} 
		catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}

	public static void getAllStudent() 
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from studentdb.student");
			
			while(rs.next())
			{
				String name=rs.getString("studentName");
				String email=rs.getString("studentEmail");
				int marks=rs.getInt("studentMarks");
				int id=rs.getInt("studentId");
				
//				System.out.println(id+" "+name+" "+email+" "+marks);
				System.out.printf("%-5d %-10s %-20s %4d%n", id, name, email, marks);	
			}
			
			rs.close();stmt.close();con.close();
			
		} 
		catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}

	public static void updateStudentById() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Student id");
		int id=sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
			PreparedStatement pstmt = con.prepareStatement("Update studentdb.student set studentMarks=33 where studentId=?");
			pstmt.setInt(1, id);
			
			int rs = pstmt.executeUpdate();
			
			System.out.println(rs+" records Updated");
	
			pstmt.close();con.close();
			
		} 
		catch (Exception e) {
		
			e.printStackTrace();
		}
	}

	public static void deleteStudentById() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Student id");
		int id=sc.nextInt();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
			PreparedStatement pstmt = con.prepareStatement("Delete from studentdb.student where studentId=?");
			pstmt.setInt(1, id);
			
			int rs = pstmt.executeUpdate();
			
			System.out.println(rs+" records deleted");
	
			pstmt.close();con.close();
			
		} 
		catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}

}
