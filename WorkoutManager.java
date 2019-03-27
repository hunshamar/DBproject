package projectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class WorkoutManager {
	
	private int highestWorkoutID;
	private static ArrayList<Workout> listOfWorkouts = new ArrayList<Workout>();

	private static ArrayList<Note> listOfNotes = new ArrayList<Note>();
	
	public WorkoutManager()
	{
		
	}
	
	
	public static void CreateWorkout(String date, String length, int personalShape, int performance, String noteText, 
			boolean createNote, ArrayList<Integer> listOfExercises) 
			throws SQLException
	{		
		// Create workout object
		Workout workout = new Workout(date, length, personalShape, performance);
		
		// Create the workout in Database
		workout.CreateWorkoutInDatabase();
		
		System.out.println("Created workout: \n" + workout.ToString());
		
		if (createNote)
		{
			Note note = new Note(workout, noteText);
			
			System.out.println("Created note: \n" + note.ToString());
			
			note.CreateNoteInDatabase();
		} 	
		
		if (listOfExercises.size() > 0)
		{
			// Add exercises to workout in Database
		}
	}
	
	public static String GetWorkout(int workoutID)
	{
		Workout workout = new Workout();
		
		workout.LoadFromDataBase(workoutID);
		
		Note note = new Note(workout);
		
		try 
		{
			note.LoadFromDataBase(workoutID);
			
			workout.setNote(note);  
		} 
		catch (SQLException e) 
		{
			System.out.println("No such note exists in the database");
			e.printStackTrace();
		}
		String workoutAndNoteAsString = workout.ToString() + note.ToString();
		
		return workoutAndNoteAsString;	
	}
	
	public static void EditWorkout(int workoutID, String date, String length, int personalShape, int performance, String noteText, boolean createNote)
	{
		try {
			Workout.EditWorkoutInDatabase(workoutID, date, length, personalShape, performance);
			
			if (createNote)
			{
				try {
					Note.EditNoteInDatabase(workoutID, noteText);
				} catch (SQLException e) {
					System.out.println("Couldn't edit Note in database");
					e.printStackTrace();
				}
			}
			else {	
				try {
					Note.DeleteNoteInDatabase(workoutID);
				} catch (Exception e) {
					System.out.println("Couldn't delete Note in database");
					e.printStackTrace();
				}
			}
			
		} catch (SQLException e) {
			System.out.println("Could not edit workout in database");
			e.printStackTrace();
		}
	}
	
	
	private static void UpdateListOfWorkouts()
	{
		listOfWorkouts.clear();
		listOfNotes.clear();
		try {
    		Connection myConn = DriverManager.getConnection(Driver.url, Driver.username, Driver.password);
     
			Statement myStat = myConn.createStatement();
		    ResultSet myRs = myStat.executeQuery("SELECT * FROM Workout");
		    while(myRs.next())
		    {
		       	Workout workout = new Workout();
		    	workout.setWorkoutID(Integer.parseInt(myRs.getString("WorkoutID")));
		    	workout.setDate(myRs.getString("dateW"));
		    	workout.setLength(myRs.getString("LengthW"));
		    	workout.setPersonalShape(Integer.parseInt(myRs.getString("PersonalShape")));
		    	workout.setPerformance(Integer.parseInt(myRs.getString("performance")));
		    	
		    	listOfWorkouts.add(workout);
			}
		    myRs = myStat.executeQuery("SELECT * FROM Note");
		    while(myRs.next())
		    {
		    	Note note = new Note();
		    	note.setNoteID(Integer.parseInt(myRs.getString("NoteID")));
		    	note.SetWorkoutID(Integer.parseInt(myRs.getString("WorkoutID")));
		    	note.setText(myRs.getString("descriptionN"));
		    	
		    	listOfNotes.add(note);
		    }
		    
		    // Attach the notes to the workouts
		    for (int i = 0; i < listOfNotes.size(); i++)
		    {
		    	for (int j = 0; j < listOfWorkouts.size(); j++) {
		    		if (listOfNotes.get(i).GetWorkoutID() == listOfWorkouts.get(j).getWorkoutID())
		    		{
		    			listOfWorkouts.get(j).setNote(listOfNotes.get(i));
		    		}
		    	}
		    }
			
	    	myConn.close();
            }
    
	    catch (Exception e) {
		    e.printStackTrace();
	    }
	}
	
	public static void PrintWorkouts()
	{	
		UpdateListOfWorkouts();
		
		for (int i = 0; i < listOfWorkouts.size(); i++)
		{
			System.out.println(listOfWorkouts.get(i).GetWorkoutAndNoteAsString());
		}
	}
	
	public static void PrintNLatestWorkouts(int n)
	{
		UpdateListOfWorkouts();
		
		if (listOfWorkouts.size() < n)
		{
			n = listOfWorkouts.size();
		}
		
		for (int i = listOfWorkouts.size() - 1; i > listOfWorkouts.size() - n; i--)
		{
			System.out.println(listOfWorkouts.get(i).GetWorkoutAndNoteAsString());
		}
	}
	
	
	public static ArrayList<Integer> GetListOfWorkoutIDs()
	{
		UpdateListOfWorkouts();
		
		ArrayList<Integer> listOfWorkoutIDs = new ArrayList<Integer>();
		
		for (int i = 0; i < listOfWorkouts.size(); i++)
		{
			listOfWorkoutIDs.add(listOfWorkouts.get(i).getWorkoutID());
		}
		return listOfWorkoutIDs;
	}
	
	
	
	public static void DeleteWorkout(int workoutID)
	{
		try {
			Workout.DeleteWorkoutInDatabase(workoutID);
		} catch (Exception e) {
			System.out.println("Workout couldn't be deleted");
			e.printStackTrace();
		}
	}

	

	
	
	
	
	// Legacy code
	private void UpdateHighestWorkoutID()
	{
		try {
			highestWorkoutID = GetHighestWorkoutID() + 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Legacy code
	private int GetHighestWorkoutID() throws Exception
	{
		Driver driver = new Driver();
		
		ResultSet rs = driver.myStat.getGeneratedKeys();
		int autoIncKeyFromApi= 0;
	    if (rs.next()) {
	        autoIncKeyFromApi = rs.getInt(1);
	    } else {

	        // throw an exception from here
	    	throw new Exception();
	    }
	    
	    return autoIncKeyFromApi;
	}
	
	

}
