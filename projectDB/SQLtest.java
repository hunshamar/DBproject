package projectDB;

import java.sql.*;

public class SQLtest {
	// private static final String driver = "com.mysql.jdbc.Driver";
	private static final String db_name = "workoutProgram";
	private static final String url = "jdbc:mysql://localhost:3306/" + db_name +  "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String username = "root";
	private static final String password = "password";
	
	public static void main(String[] args) {
				

			printAllWorkouts();


		
	}
	private static void printAllWorkouts(){
		try {
		Connection myConn = DriverManager.getConnection(url, username, password);
			// 2. Create a statement
			Statement myStat = myConn.createStatement();
		ResultSet myRs = myStat.executeQuery("SELECT * FROM Workout");
		while(myRs.next()){
				System.out.println("Workout ID: "+myRs.getString("WorkoutID"));
				System.out.println("	Date: "+myRs.getString("dateW"));
				System.out.println("	Length:"+myRs.getString("LengthW"));
				System.out.println("	Personal shape: "+myRs.getString("PersonalShape"));
				System.out.println("	Performance: "+myRs.getString("performance")+"\n");
			}
			
		myConn.close();
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	} 
}