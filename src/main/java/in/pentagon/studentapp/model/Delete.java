package in.pentagon.studentapp.model;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDaoImpl;
import in.pentagon.studentapp.dao.StudentDAO;

public class Delete {
	public static void delete() {
		Scanner sc=new Scanner(System.in);
		StudentDAO dao=new StudentDaoImpl();
		System.out.println("Enter the user id of the record which has to be deleted:");
		boolean res=dao.deleteStudent(sc.nextInt());
		if(res) {
			System.out.println("User record deleted successfully");
		}
		else {
			System.out.println("Failed to delete the data");
		}
	}

}
