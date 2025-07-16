package in.pentagon.studentapp.model;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDaoImpl;
import in.pentagon.studentapp.dto.Student;

public class ForgotPassword {
	public static void changePassword() {
		Scanner sc=new Scanner(System.in);
		StudentDAO dao=new StudentDaoImpl();
		System.out.println("Enter your phone no");
		long phone=sc.nextLong();
		System.out.println("Enter your email");
		String email=sc.next();
		Student st=dao.getStudent(phone, email);
		if(st!=null) {
			System.out.println("Enter the new password");
			String pass=sc.next();
			System.out.println("Confirm password");
			String confpass=sc.next();
			if(pass.equals(confpass)) {
				st.setPassword(pass);
				boolean res=dao.updateStudent(st);
				if(res) {
					System.out.println("Password reset successfull");
				}
				else {
					System.out.println("Password reset failed");
				}
			}
			else {
				System.out.println("Password and Confirm Password does not match");
			}
		}
		else {
			System.out.println("Student not found!");
		}
	}

}
