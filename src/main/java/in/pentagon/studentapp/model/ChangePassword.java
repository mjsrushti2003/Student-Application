package in.pentagon.studentapp.model;

import java.util.*;
import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDaoImpl;
import in.pentagon.studentapp.dto.Student;

public class ChangePassword {
	public static void change() {
		Scanner sc= new Scanner(System.in);
		StudentDAO dao=new StudentDaoImpl();
		System.out.println("Enter your old password:");
		Student st=dao.changepassword(sc.next());
		System.out.println("Enter new password");
		String password=sc.next();
		System.out.println("Confirm password");
		String Confpassword=sc.next();
		if(password.equals(Confpassword)) {
			st.setPassword(Confpassword);
			boolean res=dao.updateStudent(st);
			if(res) {
				System.out.println("Password changed successfully.");
			}
			else {
				System.out.println("Failed to change password");
			}
		}
		else {
			System.out.println("password mismatch!");
		}
	}
}
