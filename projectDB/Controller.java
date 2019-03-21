package projectDB;

import java.sql.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;  // Import the Scanner class



public class Controller{
	public static enum MenuItem{
		WORKOUT,
		EXERCISE,
		EQUIPMENT,
		GROUP_OF_EXERCISES
	}
	
	public static enum SubmenuItem{
		CREATE,
		VIEW,
		EDIT,
		DELETE,
		AVGKILOS,
		VIEW_EXERCISES_BODYPART,
		LOG
	}
	

	
	static Scanner myScanner;
	static MenuItem menuItem;
	static SubMenuitem submenuItem;

	public static void main(String[] args) {
		
		UserInterface ui = new UserInterface();
		

	    
	  	 menuItem =  ui.DrawMainMenu(); 
		
		

		switch (menuItem){
			case WORKOUT:
				submenuItem = ui.DrawSubmenuWorkout();

				switch (submenuItem){
					case CREATE:
						//WorkOut newWorkOut = ui.CreateWorkout();
						break;
					case VIEW:
												
						break;
					case EDIT:
						break;
					case DELETE:
						break;
					case LOG:
						break;
				}
				break;
			case EXERCISE:
				submenuItem = ui.DrawSubmenuExercise();
				switch (submenuItem){
					case CREATE:
						break;
					case VIEW:
						break;
					case EDIT:
						break;
					case DELETE:
						break;
					case AVGKILOS:
						break;
				}
				break;
			case EQUIPMENT:
				submenuItem = ui.DrawSubmenuExercise();
				switch (submenuItem){
					case CREATE:
						break;
					case VIEW:
						break;
					case EDIT:
						break;
					case DELETE:
						break;
				}
				break;
			case GROUP_OF_EXERCISES:
				submenuItem = ui.DrawSubmenuExercise();
				switch (submenuItem){
					case CREATE:
						break;
					case VIEW:
						break;
					case EDIT:
						break;
					case DELETE:
						break;
					case VIEW_EXERCISES_BODYPART:
						break;
				}
				break;
			default:
				//error 
		}
		  

	    ui.DrawOptions("Workout");
	    
	    myScanner.close();
	}

	private void printExercises(ResultSet exercises){
		while (exercises.Next()){
			System.out.prinln("Workout:",myRs.getString("WorkoutID"));
			System.out.prinln("Date:",myRs.getString("DateW"));
			System.out.prinln("Length:",myRs.getString("LengthW"));
			System.out.prinln("Personal Shape:",myRs.getString("PersonalShape"));
			System.out.prinln("Performance:",myRs.getString("performance"));
		}
	} 
}