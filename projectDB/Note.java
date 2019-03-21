package projectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Note {

	private int noteID;
	private String txt;
	private int workoutID;
	
	public Note(int workoutID, String txt) throws Exception{
		this.setTxt(txt);
		this.workoutID = workoutID;
		
		Driver driver = new Driver();
		driver.myStat.executeUpdate("INSERT INTO Note VALUES (default, "+ workoutID +","+ txt+")"); // Create!
		driver.myConn.close();
		
		
		this.setNoteID(noteID);
	}

	public static void editNote(int workoutID, String noteTxt) throws SQLException{
		Driver driver = new Driver();	
		driver.myStat.executeUpdate("UPDATE Note SET descriptionN = "+noteTxt+ "  WHERE workoutID =" + workoutID);
		driver.myConn.close();
	}
	
	public static void delNote(int workoutID) throws Exception{
		
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
	
	public int getNoteID() {
		return noteID;
	}

	public void setNoteID(int noteID) {
		this.noteID = noteID;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	
	
}
