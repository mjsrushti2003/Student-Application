package in.pentagon.studentapp.model;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDaoImpl;
import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dto.Student;

public class Signup {
	public static void signup() {
		Scanner sc=new Scanner(System.in);
		Student s=new Student();
		StudentDAO dao=new StudentDaoImpl();
		System.out.println("Enter the name: ");
		s.setName(sc.next());
		System.out.println("Enter the Phone number: ");
		s.setPhone(sc.nextLong());
		System.out.println("Enter the Mail: ");
		s.setMail(sc.next());
		System.out.println("Enter the Branch: ");
		s.setBranch(sc.next());
		System.out.println("Enter the Location: ");
		s.setLoc(sc.next());
		System.out.println("Enter the Password: ");
		String password=sc.next();
		System.out.println("Confirm password: ");
		String confpassword=sc.next();
		if(confpassword.equals(password)) {
			s.setPassword(confpassword);
			if(dao.insertStudent(s)) {
				System.out.println("Data Added successfully");
			}
			else {
				System.out.println("Failed to add data");
			}
		}
		else {
			System.out.println("Password Mismatch!");
		}
	}
}
