package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import Beans.User;
import SQLQuery.SQLClient;
import Util.InputUtil;

public class LoginController {

	Scanner scan=InputUtil.getScanner();
	SQLClient sql=new SQLClient();
	public User validateLogin() throws ClassNotFoundException, SQLException, IOException {
		
		String userName="";
		String password="";
		System.out.println("Enter Username");
		userName=scan.nextLine().strip();
		System.out.println("Enter Password");
		password=scan.nextLine().strip();
		if(sql.checkUserNameAlreadyExist(userName)) {
			User user=sql.getUser(userName);
			if(user.getPassword().equals(password)) {
				return user;
			}else return null;
		}
		return null;
	}
	
	public void loginMenu() throws ClassNotFoundException, SQLException, IOException {
		
		int choice=0;
		while(true) {
			System.out.println("Welcome to login menu");
			System.out.println("1. Login\n2. Go back");
			choice=scan.nextInt();
			if(choice==1) {
				User user=validateLogin();
				if(user==null) {
					System.out.println("username or password invalid");
				}else {
					System.out.println("Hello "+user.getFirstName()+" "+user.getLastName());
					System.out.println("1. Logout");
					choice=scan.nextInt();
					if(choice==1) {
						return;
					}else {
						System.out.println("Invalid Choice");
					}
				}
			}else if(choice==2) {
				return;
			}else {
				System.out.println("Invalid Choice");
			}
			
			
		}
		
	}
	
}
