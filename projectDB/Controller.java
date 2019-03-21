package projectDB;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;  // Import the Scanner class

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


public class Controller{


	
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
						WorkOut newWorkOut = ui.CreateWorkout();
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
}