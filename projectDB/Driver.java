package projectDB;

import java.sql.*;

public class Driver {

	
	public static final String db_name = "db_project_workout";
	public static final String url = "jdbc:mysql://localhost:3306/" +"exerciseProgram" +  "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	public static final String username = "root";
	public static final String password = "password";
	
	public Connection myConn;
	public Statement myStat;
		
	public Driver() throws SQLException {
		this.myConn = DriverManager.getConnection(url, username, password);
		this.myStat = myConn.createStatement();
		//ResultSet myRsQ = myStat.executeQuery();
		//resultSet myRsU = myStat.executeUpdate();
		//resultSet myRsI = myStat.executeInsertion();
	}
	
}
