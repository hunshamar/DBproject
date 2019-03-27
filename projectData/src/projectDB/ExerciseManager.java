package projectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ExerciseManager {
	
	private static ArrayList<Exercise> listOfExercises = new ArrayList<Exercise>();

	public ExerciseManager()
	{
		
	}
	
	public static void CreateExercise(String name, String description, String bodypart, boolean addEquipment, int EquipmentID)
	{
		Exercise exercise = new Exercise(bodypart, name, description);
		if(addEquipment)
			exercise.CreateExerciseInDatabase(EquipmentID);
		else
			exercise.CreateExerciseInDatabase();
	}
	
	public static String GetExercise()
	{
		return "";
	}
	
	private static void UpdateListOfExercises()
	{
		listOfExercises.clear();
		try {
    		Connection myConn = DriverManager.getConnection(Driver.url, Driver.username, Driver.password);
			// 2. Create a statement
			Statement myStat = myConn.createStatement();
		    ResultSet myRs = myStat.executeQuery("SELECT * FROM Exercise");

		    while(myRs.next()){
		    	
		    	Exercise exercise = new Exercise();
		    	exercise.setExerciseID(Integer.parseInt(myRs.getString("ExerciseID")));
		    	exercise.setName(myRs.getString("NameEx"));
		    	exercise.setDescription(myRs.getString("DescriptionEx"));
		    	exercise.setBodypart(myRs.getString("BodyPart"));
				
		    	listOfExercises.add(exercise);
                }
			
	    	myConn.close();
            }
    
	    catch (Exception e) {
		    e.printStackTrace();
			System.out.println(" Exercise in exManager");
	    }
	}
	
	public static ArrayList<Integer> GetListOfExerciseIDs()
	{
		UpdateListOfExercises();
		
		ArrayList<Integer> listOfExerciseIDs = new ArrayList<Integer>();
		
		for (int i = 0; i < listOfExercises.size(); i++)
		{
			listOfExerciseIDs.add(listOfExercises.get(i).getExerciseID());
		}
		return listOfExerciseIDs;
	}
	
	public static void PrintExercise()
	{
		UpdateListOfExercises();
		
		for(int i = 0; i < listOfExercises.size(); i++)
			Exercise.printExercise(listOfExercises.get(i).getExerciseID());
	}
}
