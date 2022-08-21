package JDBCConnector;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Connector {

	public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {

		FileReader reader = new FileReader("C:\\Users\\Acer\\Desktop\\Git Repo\\JDBC\\learningJDBC\\src\\main\\resources\\db.properties");
		Properties prop = new Properties();
		prop.load(reader);
		// 1. load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(prop.getProperty("db.url"), prop.getProperty("db.user"),
				prop.getProperty("db.password"));
		
	    log.info("Simple log statement with inputs {}, {} and {}", 1, 2, 3);
		return con;

	}

}
