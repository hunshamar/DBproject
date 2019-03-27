package projectDB;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NumWorkLastMonth {
	

	public static void printAntWork() throws SQLException{
		Driver driver = new Driver();
		ResultSet rs = driver.myStat.executeQuery("SELECT COUNT('WorkoutID') AS Num FROM Workout WHERE dateW BETWEEN DATE_SUB(NOW(), INTERVAL 30 DAY) AND NOW()");
		
		while(rs.next()) {
			int num = Integer.parseInt(rs.getString("Num")) ;
			System.out.println("Number of workouts last month :" +num );
			if (num > 8){
				System.out.println(" Good Work !!! ");
			}
		}
		driver.myConn.close();
	}
	
//	public static void main(String[] args) throws SQLException {
//		
//		//ResultLog log = new ResultLog("2017-01-02", "2020-02-05", 1);
//		NumWorkLastMonth.printAntWork();
//	}
}
