package in.pentagon.studentapp.model;

import java.util.ArrayList;
import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDaoImpl;
import in.pentagon.studentapp.dto.Student;
import in.pentagon.studentapp.dao.StudentDAO;
public class Search {
	public static void user() {
		Scanner sc= new Scanner(System.in);
		StudentDAO dao=new StudentDaoImpl();
		System.out.println("Enter the name of the student to search");
		ArrayList <Student> st=dao.getStudent(sc.next());
		if(st!=null) {
			for(Student s:st) {
				System.out.println("===============================");
				System.out.print(" ID :"+s.getId());
				System.out.print(" Name :"+s.getName());
				System.out.println(" Branch :"+s.getBranch());
				System.out.println("==============================");
				
			}
		}
		else {
			System.out.println("No such student!");
		}
	}
}
