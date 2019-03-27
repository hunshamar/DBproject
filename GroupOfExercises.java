package projectDB;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupOfExercises {

	private int EGID; // What is this?
	private int GroupOfExerciseID;
	private int ExerciseID;
	
	public GroupOfExercises(int GroupOfExerciseID, int ExerciseID) throws SQLException{
		Driver driver = new Driver();
		driver.myStat.executeQuery("INSERT INTO EG VALUES(default, " + GroupOfExerciseID+","+ ExerciseID+ ")");
		ResultSet rs = driver.myStat.getGeneratedKeys();
		int autoIncKeyFromApi= 0;
	    if (rs.next()) {
	        autoIncKeyFromApi = rs.getInt(1);
	    } else {
	        // throw an exception from here
	    }
	    this.setEGID(autoIncKeyFromApi);
	    this.setExerciseID(ExerciseID);
	    this.setGroupOfExerciseID(GroupOfExerciseID);
	    
	    driver.myConn.close();
	}
	
	public static void delEG(int EGID) throws SQLException{
		Driver driver = new Driver();
		driver.myStat.executeQuery("DELETE EG WHERE EGID "+ EGID);
		driver.myConn.close();
	}

	public static void editEG(int EGID, int GroupOfExerciseID, int ExerciseID) throws SQLException{
		Driver driver = new Driver();
		driver.myStat.executeQuery("UPDATE EG SET GroupOfExerciseID="+GroupOfExerciseID +
				", ExerciseID="+ ExerciseID + " WHERE EGID =" + EGID);
		driver.myConn.close();
	}
	public static void printEG(int EGID){
        try {
    		Driver driver = new Driver();
		    ResultSet myRs = driver.myStat.executeQuery("SELECT * FROM Workout WHERE EGIG =" + EGID);

		    printRS_EG(myRs);
			
	    	driver.myConn.close();
            }
    
	    catch (Exception e) {
		    e.printStackTrace();
	    }
    }
    
    
    public static void printAllEG(){
		try {
    		Driver driver = new Driver();
    		
		    ResultSet myRs = driver.myStat.executeQuery("SELECT * FROM EG");
		    printRS_EG(myRs);
			
            driver.myConn.close();
		}
	    catch (Exception e) {
		    e.printStackTrace();
	    }
	}
    
    public static void printRS_EG(ResultSet rs) throws SQLException{
    	while(rs.next()){
			System.out.println("EG ID: "+rs.getString("EGID"));
			System.out.println("	ExerciseID: "+rs.getString("ExerciseID"));
			System.out.println("	GroupOfExercisesID:"+rs.getString("groupID"));
		}
        System.out.println();
    }
    
    
    
	public int getEGID() {
		return EGID;
	}

	public void setEGID(int gEID) {
		EGID = gEID;
	}

	public int getGroupOfExerciseID() {
		return GroupOfExerciseID;
	}

	public void setGroupOfExerciseID(int groupOfExerciseID) {
		GroupOfExerciseID = groupOfExerciseID;
	}

	public int getExerciseID() {
		return ExerciseID;
	}

	public void setExerciseID(int exerciseID) {
		ExerciseID = exerciseID;
	}
}
