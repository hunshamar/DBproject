package projectDB;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GroupOfExercisesManager {

	public static void editGroupOfExercises(int groupID, ArrayList<Integer> listExIDs){
		for(int i = 0; i < listExIDs.size(); i++)
			addExerciseToGroup(groupID, listExIDs.get(i));
			
	}
	
	public static void addExerciseToGroup(int groupID, int exID){
		try {
			Driver driver = new Driver();
			driver.myStat.executeUpdate("INSERT INTO EG VALUES (default,"+ 
			exID+","+ groupID +")", Statement.RETURN_GENERATED_KEYS);
					    
			driver.myConn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
