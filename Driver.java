import java.sql.*;


public class Driver {
	// private static final String driver = "com.mysql.jdbc.Driver";
	private static final String db_name = "db_project_workout";
	private static final String url = "jdbc:mysql://localhost:3306/" +"student" +  "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String username = "root";
	private static final String password = "password";
	
	public static void main(String[] args) {
		
		try {
			// 1. Get a connection to database
			//"jdbc:mysql://localhost:3306/pizzadbase?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
			Connection myConn = DriverManager.getConnection(url, username, password);
			// 2. Create a statement
			Statement myStat = myConn.createStatement();
			// 3. Execute Sql query
			ResultSet myRs = myStat.executeQuery("SELECT * FROM students");
			/*int rowsAffected = myStat.executeUpdate("INSERT into Workout values (1, 2018-03-18, 19:30:10, 02:00:00, 1, 1)");
			ResultSet myRs2 = myStat.executeQuery("Select * FROM Workout")*/;
			// 4. Process the result set
			while(myRs.next()){
				System.out.println(myRs.getString("firstname") + myRs.getString("lastname"));
			}
			myConn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
