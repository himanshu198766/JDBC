package Client;

import java.io.IOException;
import java.sql.SQLException;

import SQLQuery.SQLClient;

public class App {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		
		SQLClient sql=new SQLClient();
		
		
		sql.createUser("Steve", "Rogers", "steve", "steve123");
		
		System.out.println(sql.getUser("steve").toString());
		
	}
}
