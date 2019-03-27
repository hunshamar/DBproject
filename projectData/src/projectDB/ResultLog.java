package projectDB;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultLog {

//	private String startInput;
//	private String endInput;
//	private int exerciseID;
//	
//	public ResultLog(String start, String end, int ID) {
//		this.startInput = start;
//		this.endInput = end;
//		this.exerciseID = ID;
//	}

	public static void printLog(String startInput, String endInput, int exerciseID) throws SQLException{
		try{
		Driver driver = new Driver();
		
		// Querie workout in Database
		ResultSet rs = driver.myStat.executeQuery("SELECT PerformanceRate, WorkoutExercises.PersonalShape, "
				+ "DateW FROM WorkoutExercises INNER JOIN Workout ON (Workout.WorkoutID = WorkoutExercises.WorkoutID)"
				+ " WHERE (dateW BETWEEN '"+ startInput + "' AND '"+ endInput +"') AND exerciseID = "+ exerciseID);
		
		while(rs.next()) {
			System.out.println("PerformanceRate : " + rs.getString("PerformanceRate"));
			System.out.println("     PersonalShape: " + rs.getString("PersonalShape"));
			System.out.println("     Date " +rs.getString("DateW"));
		}
		System.out.println("hey");
		driver.myConn.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void printRL(){
		String startInput = UserInterfaceValidation.GetDateInput("What is the beginning of the period you want the logs of");
		String endInput = UserInterfaceValidation.GetDateInput("What is the end ? ");
		int exID = UserInterfaceValidation.GetIntegerInput("What is the ID of the exercise ?", 0, Integer.MAX_VALUE);
		
		try {
			printLog(startInput, endInput, exID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*public static void main(String[] args) throws SQLException {
		
		//ResultLog log = new ResultLog("2017-01-02", "2020-02-05", 1);
		ResultLog.printLog("2017-01-02", "2020-02-05", 1);
		2000-01-02
		2020-02-05
	}*/
}



