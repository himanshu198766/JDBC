package Client;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import Controller.LoginController;
import Controller.RegisterController;
import Util.InputUtil;

public class App {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		
		
		
		System.out.println("Welcome to the App");
		Scanner scan=InputUtil.getScanner();
		int choice;
		while(true) {
			System.out.println("1. Login \n2. Register\n3. Exit");			
			choice=scan.nextInt();
			if(choice==1) {
				LoginController loginController=new LoginController();
				loginController.loginMenu();				
			}else if(choice==2) {
				RegisterController registerController=new RegisterController();
				registerController.registerMenu();
			}else if(choice==3) {
				break;
			}else {
				System.out.println("Select valid choice");
			}
		}
		
		scan.close();
		System.out.println("Successfully Exited the app");
		
	}
}
