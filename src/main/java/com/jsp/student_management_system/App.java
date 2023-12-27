package com.jsp.student_management_system;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc=new Scanner(System.in);
        System.out.println("1.Enter 1 to save data\n2.Enter 2 to get student by id\n3.Enter 3 to get All Students\n4.Enter 4 to update Student by id\n5.Enter 5 to Delete Student by id");
        int choice=sc.nextInt();
        
        switch(choice)
        {
        	case 1: StudentDAO.savaStudent();
        	break;
        	
        	case 2: StudentDAO.getStudentById();
        	break;
        	
        	case 3: StudentDAO.getAllStudent();
        	break;
        	
        	case 4: StudentDAO.updateStudentById();
        	break;
        	
        	case 5: StudentDAO.deleteStudentById();
        	break;
        	
        	default:
        		System.err.println("Invalid Choice");
        }
    }
}
