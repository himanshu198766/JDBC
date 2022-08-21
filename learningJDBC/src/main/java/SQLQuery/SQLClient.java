package SQLQuery;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.User;
import JDBCConnector.Connector;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SQLClient {
	
	public boolean checkUserNameAlreadyExist(String userName) throws ClassNotFoundException, SQLException, IOException {

		Connection con = Connector.getConnection();
		String sql="SELECT userName FROM login Where userName=?";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, userName);
		ResultSet rs = pstat.executeQuery();
		if(getSize(rs)>0) return true;
		return false;
		
	}
	
	public int getSize(ResultSet set) throws SQLException {
		int size=0;
		while(set.next())
			size++;
		return size;
	}

	public boolean createUser(String firstName, String lastName,String userName, String password )
			throws ClassNotFoundException, SQLException, IOException {
		
		if(checkUserNameAlreadyExist(userName)==true) return false;
		
		Connection con = Connector.getConnection();
		String sql = "insert into login (firstName,lastName,userName,password)  values(?,?,?,?)";
		PreparedStatement pstat = con.prepareStatement(sql); 
		pstat = con.prepareStatement(sql);
		pstat.setNString(1,firstName);
		pstat.setString(2,lastName);
		pstat.setString(3,userName);
		pstat.setString(4,password);
		pstat.executeUpdate();		
		log.info("User Created Successfully");
		return true;
	}
	
	
	public User getUser(String userName)
			throws ClassNotFoundException, SQLException, IOException {
		
		if(checkUserNameAlreadyExist(userName)==false) return null;
		
		User user=new User();
		String sql="SELECT * FROM login Where userName=?";
		Connection con = Connector.getConnection();
		PreparedStatement pstat = con.prepareStatement(sql); 
		pstat.setString(1, userName);
		ResultSet rs = pstat.executeQuery();
		
		while(rs.next()) {
			user.setFirstName(rs.getString(2));
			user.setLastName(rs.getString(3));
			user.setUserName(rs.getString(1));
			user.setPassword(rs.getString(4));
		}
		
		return user;
	}
}
