package projectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Workout {

	private int workoutID;
	private String date;
	private String length;
	private int personalShape;
	private int performance;
	private Note note;
	

	public Workout()
	{
		
	}
	
	public Workout(String date, String length, int personalShape, int performance)
	{
		this.date = date;
		this.length = length;
		this.personalShape = personalShape;
		this.performance = performance;
		
	}
	
	public void CreateWorkoutInDatabase() throws SQLException
	{
		Driver driver = new Driver();
		// Create Workout in Database
		driver.myStat.executeUpdate("INSERT INTO Workout VALUES (default, '"+ date +"', "+
												length +", "+ personalShape+ ", "+ performance +")", Statement.RETURN_GENERATED_KEYS);
			
		// Get the workoutID from the Database
		ResultSet rs = driver.myStat.getGeneratedKeys();
		int autoIncKeyFromApi= 0;
	    if (rs.next()) {
	        autoIncKeyFromApi = rs.getInt(1);
	    } else {
	        // throw an exception from here
	    }
	    
	    this.workoutID = autoIncKeyFromApi;
	    
		driver.myConn.close();
	}

	
	// Loads the Workout object with the data from the DataBase
	public void LoadFromDataBase(int workoutID)
	{
	 try {
    		Connection myConn = DriverManager.getConnection(Driver.url, Driver.username, Driver.password);
			Statement myStat = myConn.createStatement();
		    ResultSet myRs = myStat.executeQuery("SELECT * FROM Workout WHERE workoutID =" + workoutID);
		    
		    while(myRs.next()){
		    	this.workoutID = Integer.parseInt(myRs.getString("WorkoutID"));
		    	this.date = myRs.getString("dateW");
		    	this.length = myRs.getString("LengthW");
		    	this.personalShape = Integer.parseInt(myRs.getString("PersonalShape"));
		    	this.performance = Integer.parseInt(myRs.getString("performance"));
			}
		    myConn.close();
        }
	    catch (Exception e) {
		    e.printStackTrace();
	    }
	}
	
	public static void DeleteWorkoutInDatabase(int workoutID) throws Exception{
		
		Driver driver = new Driver();
		driver.myStat.executeUpdate("DELETE FROM Workout WHERE workoutID =" + workoutID); // Delete!
		driver.myConn.close();
	}
	
	public static void EditWorkoutInDatabase(int workoutID, String date, String length, int personalShape, int performance) 
			throws SQLException{
		Driver driver = new Driver();	
		driver.myStat.executeUpdate("UPDATE Workout SET dateW = "+ date +", lengthW = "+ length +", personalShape= "+ personalShape +",  "
				+ "performance = "+ performance +" WHERE workoutID =" + workoutID);	    
		driver.myConn.close();
	}
	

	
	public String ToString()
	{
		return "WorkoutID: " + workoutID + ", Date: " + date + ", Duration: " + length + ", PersonalShape: " + personalShape + 
				", Performance: " + performance + " ";
	}
	
	public String GetWorkoutAndNoteAsString()
	{
		String workoutAndNote = ToString();
		
		if (note != null)
			{
				workoutAndNote += "\n " + note.ToString();
			}
		return workoutAndNote;
	}
	
	

	public int getWorkoutID() {
		return workoutID;
	}
	public void setWorkoutID(int workoutID) {
		this.workoutID = workoutID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public int getPersonalShape() {
		return personalShape;
	}
	public void setPersonalShape(int personalShape) {
		this.personalShape = personalShape;
	}
	public int getPerformance() {
		return performance;
	}
	public void setPerformance(int performance) {
		this.performance = performance;
	}
	public Note getNote() {
		return note;
	}
	public void setNote(Note note) {
		this.note = note;
	}
	
	
	
	
}