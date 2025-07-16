package in.pentagon.studentapp.model;

import java.util.Scanner;

import in.pentagon.studentapp.dao.StudentDaoImpl;
import in.pentagon.studentapp.dto.Student;
import in.pentagon.studentapp.dao.StudentDAO;
public class Update {
	public static void  update(Student s) {
		Scanner sc=new Scanner(System.in);
		StudentDAO sdao=new StudentDaoImpl();
		int choice=0;
		System.out.println("Enter the feild to be updated");
		do {
			System.out.println("1. NAME");
			System.out.println("2. PHONE");
			System.out.println("3. EMAIL");
			System.out.println("4. BRANCH");
			System.out.println("5. LOCATION");
			System.out.println("6. BACK TO MAIN MENU");
			choice=sc.nextInt();
			switch(choice) {
			case 1:System.out.println("Enter the Name to be updated");
				   s.setName(sc.next());
				   break;
			case 2:System.out.println("Enter the New Phone number");
			       s.setPhone(sc.nextLong());
				   break;
			case 3:System.out.println("Enter the New Mail");
			   	   s.setMail(sc.next());
				   break;
			case 4:System.out.println("Enter the New Branch");
			       s.setBranch(sc.next());
				   break;
			case 5:System.out.println("Enter the New location");
			       s.setLoc(sc.next());
				   break;
			case 6:System.out.println("back to main menu:");
				   break;
			default:System.out.println("Invalid choice!");
				   break;
			}
			Boolean res=sdao.updateStudent(s);
			if(res) {
				System.out.println("Data updated successfully");
			}
			else {
				System.out.println("Failed to update");
			}
		}while(choice!=6);

	}

}
