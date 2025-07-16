package in.pentagon.studentapp.model;

import java.util.ArrayList;
import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDAO;
import in.pentagon.studentapp.dao.StudentDaoImpl;
import in.pentagon.studentapp.dto.Student;

public class Login {
	public static void login() {
		Scanner sc=new Scanner(System.in);
		StudentDAO dao=new StudentDaoImpl();
		System.out.println("Enter your email :");
		String Mail=sc.next();
		System.out.println("Enter your password :");
		String password=sc.next();
		Student st=dao.getStudent(Mail, password);
		int choice=0;
		if(st==null){
			System.out.println("Login failed!");
		}
		else {
			System.out.println("Welcome ,"+st.getName());
			do {
                System.out.println("1. VIEW YOUR ACCOUNT");
                System.out.println("2. UPDATE YOUR ACCOUNT");
                System.out.println("3. CHANGE PASSWORD");
                System.out.println("4. SEARCH USER");
                System.out.println("5. MAIN MENU");
                if(st.getId()==1) {
                    System.out.println("6. VIEW ALL USER");
                    System.out.println("7. DELETE USER");
                }
                choice = sc.nextInt();
                switch (choice) {
                    case 1:System.out.println(st);
                        break;
                    case 2:Update.update(st);
                        break;
                    case 3:ChangePassword.change();
                    break;
                    case 4:Search.user();
                        break;
                    case 5:System.out.println("Back to Main menu");
                        break;
                    case 6:ArrayList<Student> studentlist=dao.getStudent();
             	   			for(Student s:studentlist) {
             	   				System.out.println(s);
             	   				}
                        break;
                    case 7:Delete.delete();
                        break;
                    default:
                        System.out.println("invalid choice, Please enter valid choice");
                }
            } while (choice != 5);
		}	
	}
}
