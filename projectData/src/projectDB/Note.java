package projectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Note {

	private int noteID;
	private String text;
	private int workoutID;
	private Workout workout;
	
	
	public Note(Workout workout, String text)
	{
		this.text = text;
		this.workout = workout;
		this.workoutID = workout.getWorkoutID();
		
	}
	
	public Note()
	{
		
	}
	
	public void CreateNoteInDatabase() throws SQLException
	{
		Driver driver = new Driver();
		driver.myStat.executeUpdate("INSERT INTO Note VALUES (default, "+ workoutID +",'"+ text+"')"); // Create!
		driver.myConn.close();
		
		this.setNoteID(noteID);
	}
	
	public Note(int workoutID)
	{
		this.workoutID = workoutID;
	}
	
	public Note(Workout workout)
	{
		this.workout = workout;
	}
	
	public void LoadFromDataBase(int workoutID) throws SQLException
	{
		Connection myConn = DriverManager.getConnection(Driver.url, Driver.username, Driver.password);
		Statement myStat = myConn.createStatement();
	   	ResultSet myRs = myStat.executeQuery("SELECT * FROM Note WHERE workoutID =" + workoutID);
	    
	   	while(myRs.next()){
			noteID = Integer.parseInt(myRs.getString("NoteID"));
			text = myRs.getString("descriptionN");
	   	}
	   	myConn.close();
	}

	public static void EditNoteInDatabase(int workoutID, String noteTxt) throws SQLException{
		Driver driver = new Driver();	
		driver.myStat.executeUpdate("UPDATE Note SET descriptionN = "+noteTxt+ "  WHERE workoutID =" + workoutID);
		driver.myConn.close();
	}
	
	public static void DeleteNoteInDatabase(int workoutID) throws Exception{
		
		Driver driver = new Driver();
		driver.myStat.executeUpdate("DELETE FROM Note WHERE workoutID =" + workoutID); // Delete!
		driver.myConn.close();
	}
	
	public static void printAllNotes(){
		try {
    		Connection myConn = DriverManager.getConnection(Driver.url, Driver.username, Driver.password);
			// 2. Create a statement
			Statement myStat = myConn.createStatement();
		    ResultSet myRs = myStat.executeQuery("SELECT * FROM Note");
		    while(myRs.next()){
				System.out.println("Note ID: "+myRs.getString("NoteID"));
				System.out.println("	WorkoutID: "+myRs.getString("workoutID"));
				System.out.println("	Description:"+myRs.getString("descriptionN"));
			}
            System.out.println();
			
	    	myConn.close();
            }
    
	    catch (Exception e) {
		    e.printStackTrace();
	    }
	} 
	
	public String ToString()
	{
		return "Note: " + text;
	}
	
	public int getNoteID() {
		return noteID;
	}

	public void setNoteID(int noteID) {
		this.noteID = noteID;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public void SetWorkoutID(int workoutID)
	{
		this.workoutID = workoutID;
	}

	public int GetWorkoutID()
	{
		return workoutID;
	}
	
	
}