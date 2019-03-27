package projectDB;


import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;  // Import the Scanner class


public class Controller{

	static Scanner myScanner;


	public static void main(String[] args) {
		
		MainMenu();
		

	    
	  	
	}
	
	public static void MainMenu()
	{
		int menuSelection = UserInterface.MainMenu();
		
		switch(menuSelection)
		{
		case 1:
			SubMenuWorkout();
			break;
		case 2:
			SubMenuExercise();
			break;
		case 3:
			SubMenuEquipment();
			break;
		case 4:
			SubMenuGroupOfExercises();
			
		case 5 : 
			ResultLog.printRL();
			
			MainMenu();
			break;
			
		case 6 :
			try {
				NumWorkLastMonth.printAntWork();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			MainMenu();
			break;
			
		case 7:
			System.out.println("Exited program");
			System.exit(0);
		}
	}
	
	public static void SubMenuWorkout()
	{
		int menuSelection = UserInterface.SubMenuWorkout();
		
		switch(menuSelection)
		{
		case 1:
			UserInterface.CreateWorkout();
			
			//Navigate to the Sub Menu after Creating workout
			SubMenuWorkout();
			break;
		case 2:
			UserInterface.ViewWorkouts();
			
			
			//Navigate to the Sub Menu after Viewing workout
			SubMenuWorkout();
			break;
		case 3: 
			UserInterface.EditWorkout();
			
			//Navigate to the Sub Menu after Editing workout
			SubMenuWorkout();
			break;
		case 4:
			UserInterface.DeleteWorkout();
			
			//Navigate to the Sub Menu after Deleting workout
			SubMenuWorkout();
			break;
		case 5:
			UserInterface.ViewNLatestWorkouts();
			
			// Navigate to the Sub Menu afterwards
			SubMenuWorkout();
			break;
		case 6:
			UserInterface.ViewExercisesOfWorkout();
			
			// Navigate to the Sub Menu afterwards
			SubMenuWorkout();
			break;
		case 7:
			MainMenu();
			break;
		}
	}
	
	public static void SubMenuExercise()
	{
		int menuSelection = UserInterface.SubMenuExercise();
		
		switch(menuSelection)
		{
		case 1:
			UserInterface.CreateExercise();
			
			//Navigate to the Sub Menu afterwards
			SubMenuExercise();
			break;
		case 2:
			UserInterface.ViewExercises();
			//Navigate to the Sub Menu afterwards
			SubMenuExercise();
			break;
		case 3:
			UserInterface.EditExercise();
			//Navigate to the Sub Menu afterwards
			SubMenuExercise();
			break;
		case 4:
			//UserInterface.AverageKilosExercise();
			//Navigate to the Sub Menu afterwards
			System.out.println("Removed function");
			SubMenuExercise();
			break;
		case 5:
			UserInterface.DeleteExercise();
			//Navigate to the Sub Menu afterwards
			SubMenuExercise();
			break;
		case 6:
			MainMenu();
			break;
		}
	}
	
	public static void SubMenuGroupOfExercises()
	{
		int menuSelection = UserInterface.SubMenuGroupOfExercises();
		
		switch(menuSelection)
		{
		case 1:
			try {
				UserInterface.CreateGroupOfExercises();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Navigate to the Sub Menu afterwards
			SubMenuGroupOfExercises();
			break;
		case 2:
			UserInterface.ViewGroupOfExercises();
			//Navigate to the Sub Menu afterwards
			SubMenuGroupOfExercises();
		break;
		case 3:
			UserInterface.ViewGroupSimilarity();
			//Navigate to the Sub Menu afterwards
			SubMenuGroupOfExercises();
			break;
		case 4:
			UserInterface.EditGroupOfExercises();
			//Navigate to the Sub Menu afterwards
			SubMenuGroupOfExercises();
			break;
		case 5:
			UserInterface.DeleteGroupOfExercises();
			//Navigate to the Sub Menu afterwards
			SubMenuGroupOfExercises();
			break;
		
		case 6:
			// Print all exercises linked to Group
			GroupOfExercises.printAllEG();
			
			SubMenuGroupOfExercises();
			break;
		case 7:
			MainMenu();
			break;
		}
	}
	
	public static void SubMenuEquipment()
	{
		int menuSelection = UserInterface.SubMenuEquipment();
		
		switch(menuSelection)
		{
		case 1:
			UserInterface.CreateEquipment();
			
			//Navigate to the Sub Menu afterwards
			SubMenuEquipment();
			break;
		case 2:
			UserInterface.ViewEquipment();
			//Navigate to the Sub Menu afterwards
			SubMenuEquipment();
			break;
		case 3:
			UserInterface.EditEquipment();
			//Navigate to the Sub Menu afterwards
			SubMenuEquipment();
			break;
		case 4:
			UserInterface.DeleteEquipment();
			//Navigate to the Sub Menu afterwards
			SubMenuEquipment();
			break;
		case 5:
			MainMenu();
			break;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}