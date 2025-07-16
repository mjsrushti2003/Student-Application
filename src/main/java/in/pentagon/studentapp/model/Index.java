package in.pentagon.studentapp.model;
import java.util.Scanner;
public class Index {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int choice=0;
		System.out.println("Welcome to student app : ");
		do {
			System.out.println("1. SIGNUP");
			System.out.println("2. LOGIN");
			System.out.println("3. FORGOT PASSWORD");
			System.out.println("4. EXIT");
			choice=s.nextInt();
			switch(choice) {
			case 1:Signup.signup();
				break;
			case 2:Login.login();
				break;
			case 3:ForgotPassword.changePassword();
				break;
			case 4:System.out.println("Thank you");
				break;
			default:System.out.println("Invalid choice,Please enter valid choice!");
				break;
			}
		}while(choice!=4);
		s.close();
	}
}