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
	
	
	public Workout(String date, String length, int personalShape, int performance, String noteTxt) throws Exception{
		super();
		this.setDate(date);
		this.setLength(length);
		this.setPersonalShape(personalShape);
		this.setPerformance(performance);
		
		Driver driver = new Driver();
		int ID = driver.myStat.executeUpdate("INSERT INTO Workout VALUES (default, "+ date +", "+
												length +", "+ personalShape+ ", "+ performance +")", Statement.RETURN_GENERATED_KEYS); // Create!
		System.out.println("First ID :" +driver.myStat.getGeneratedKeys());
		
		ResultSet rs = driver.myStat.getGeneratedKeys();
		int autoIncKeyFromApi= 0;
	    if (rs.next()) {
	        autoIncKeyFromApi = rs.getInt(1);
	    } else {

	        // throw an exception from here
	    }
	    System.out.println(autoIncKeyFromApi);
	
		this.workoutID = autoIncKeyFromApi;
		this.setWorkoutID(autoIncKeyFromApi);
		
		Note note = new Note(autoIncKeyFromApi, noteTxt);
		this.setNote(note);
		
		driver.myConn.close();

	}
	
	public void delWorkout(int workoutID) throws Exception{
		
		Driver driver = new Driver();
		driver.myStat.executeUpdate("DELETE FROM Workout WHERE workoutID =" + workoutID); // Delete!
		driver.myConn.close();
	}
	
	public void editWorkout(int workoutID, String date, String length, int personalShape, int performance, String noteTxt) throws SQLException{
		Driver driver = new Driver();	
		driver.myStat.executeUpdate("UPDATE Workout SET dateW = "+date +", lengthW = "+ length +", personalShape= "+ personalShape+",  performance = "+performance+" WHERE workoutID =" + workoutID);

	    ResultSet myRs = driver.myStat.executeQuery("SELECT COUNT(*) FROM Note WHERE workoutID =" + workoutID);
	    int i = 0;
	    while(myRs.next()){
	    	i++;
	    }
	    if(i > 0){
			driver.myStat.executeUpdate("UPDATE Note SET dateW = "+date +", lengthW = "+ length +", personalShape= "+ personalShape+",  performance = "+performance+" WHERE workoutID =" + workoutID);

	    }
	    System.out.println("Number of notes : " + i);
		//driver.myStat.executeUpdate("UPDATE Note SET description=)
		driver.myConn.close();
	}
	
	
    public static void printWorkout(int ID){
        try {
    		Connection myConn = DriverManager.getConnection(Driver.url, Driver.username, Driver.password);
			// 2. Create a statement
			Statement myStat = myConn.createStatement();
		    ResultSet myRs = myStat.executeQuery("SELECT * FROM Workout WHERE workoutID =" + ID);
		    while(myRs.next()){
				System.out.println("Workout ID: "+myRs.getString("WorkoutID"));
				System.out.println("	Date: "+myRs.getString("dateW"));
				System.out.println("	Length:"+myRs.getString("LengthW"));
				System.out.println("	Personal shape: "+myRs.getString("PersonalShape"));
				System.out.println("	Performance: "+myRs.getString("performance")+"\n");
			}
            System.out.println();
			
	    	myConn.close();
            }
    
	    catch (Exception e) {
		    e.printStackTrace();
	    }
    }
    
    
    public static void printAllWorkouts(){
		try {
    		Connection myConn = DriverManager.getConnection(Driver.url, Driver.username, Driver.password);
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
            System.out.println();
			
	    	myConn.close();
            }
    
	    catch (Exception e) {
		    e.printStackTrace();
	    }
	} 
	
	
	 public void printNoteForWorkout(){
			try {
	    		Connection myConn = DriverManager.getConnection(Driver.url, Driver.username, Driver.password);
				// 2. Create a statement
				Statement myStat = myConn.createStatement();
			    ResultSet myRs = myStat.executeQuery("SELECT * FROM note WHERE workoutID ="+ this.workoutID);
			    while(myRs.next()){
					System.out.println("Note ID: "+myRs.getString("NoteID"));
					System.out.println("	For workout with ID: "+myRs.getString("WorkoutID"));
					System.out.println("	Description:" +myRs.getString("DescriptionN"));
				}
	            System.out.println();
				
		    	myConn.close();
	            }
	    
		    catch (Exception e) {
			    e.printStackTrace();
		    }
	    } 
	
	public static void printAllNotes(){
		try {
    		Connection myConn = DriverManager.getConnection(Driver.url, Driver.username, Driver.password);
			// 2. Create a statement
			Statement myStat = myConn.createStatement();
		    ResultSet myRs = myStat.executeQuery("SELECT * FROM note");
		    while(myRs.next()){
				System.out.println("Note ID: "+myRs.getString("NoteID"));
				System.out.println("	For workout with ID: "+myRs.getString("WorkoutID"));
				System.out.println("	Description:" +myRs.getString("DescriptionN"));
            }
            System.out.println();
			
	    	myConn.close();
            }
    
	    catch (Exception e) {
		    e.printStackTrace();
	    }
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
