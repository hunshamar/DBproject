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
		GROUP_OF_EXERCISES,
		EXIT
	}
	
	public static enum SubmenuItem{
		CREATE,
		VIEW,
		EDIT,
		DELETE,
		AVGKILOS,
		VIEW_EXERCISES_BODYPART,
		LOG,
		BACK
	}


		

	
	static Scanner myScanner;
	static MenuItem menuItem;
	static SubMenuitem submenuItem;

	public static void main(String[] args) {
		
		//UserInterface ui = new UserInterface();
		

	    
	  	//menuItem =  ui.DrawMainMenu(); 
		
		menuItem = MenuItem.WORKOUT; // mainMenu();



		while (menuItem != SubmenuItem.EXIT){		

			switch (menuItem){
				case WORKOUT:
					submenuItem =  SubmenuItem.VIEW; //ui.DrawSubmenuWorkout();

					switch (submenuItem){
						case SubmenuItem.CREATE:
							System.out.println("Create workout:");
							//WorkOut newWorkOut = ui.CreateWorkout();
							break;
						case SubmenuItem.VIEW:
							System.out.println("view workout:");
							SQLPrint.printAllWorkouts();												
							break;
						case SubmenuItem.EDIT:
							System.out.println("Edit workout:");
							break;
						case SubmenuItem.DELETE:
						System.out.println("Delete workout:");
							break;
						case SubmenuItem.LOG:
						System.out.println("Log:");
							break;
					}
					break;
				case EXERCISE:
					submenuItem = SubmenuItem.VIEW;// ui.DrawSubmenuExercise();
					switch (submenuItem){
						case SubmenuItem.CREATE:
							System.out.println("Create exercise:");
							break;
						case SubmenuItem.VIEW:
							System.out.println("view exercises:");
							SQLPrint.printAllExercises();
							break;
						case SubmenuItem.EDIT:
							System.out.println("Edit exercise:");
							break;
						case SubmenuItem.DELETE:
							System.out.println("Delete exercise:");
							break;
						case SubmenuItem.AVGKILOS:
							System.out.println("Average kg of an exercise:");
							break;
					}
					break;
				case EQUIPMENT:
					submenuItem = SubmenuItem.VIEW;//ui.DrawSubmenuExercise();
					switch (submenuItem){
						case SubmenuItem.CREATE:
							System.out.println("Add new equipment:");
							break;
						case SubmenuItem.VIEW:
							System.out.println("View equipment:");
							SQLprint.PrintAllEquipment();
							break;
						case SubmenuItem.EDIT:
							System.out.println("Edit equipment:");
							break;
						case SubmenuItem.DELETE:
							System.out.println("Delete new equipment:");
							break;
					}
					break;
				case GROUP_OF_EXERCISES:
					submenuItem =  SubmenuItem.VIEW;//ui.DrawSubmenuExercise();
					switch (submenuItem){
						case SubmenuItem.CREATE:
							System.out.println("Create group of exercises");
							break;
						case SubmenuItem.VIEW:
							System.out.println("View group of exercises");
							break;
						case SubmenuItem.EDIT:
							System.out.println("Edit group of exercises");							
							break;
						case SubmenuItem.DELETE:
							System.out.println("Delete group of exercises");
							break;
						case SubmenuItem.VIEW_EXERCISES_BODYPART:
							System.out.println("View exercises of specific body part");
							break;
					}
					break;
				case SubmenuItem.EXIT:
					System.out.println("EXITING");
				default:
					//error 
			}
		}
		  
	}


	
	public MenuItem MenuItem(){
		System.out.println();
		System.out.println("main menu : Please select an action");
		
		System.out.println("[1] Workout ");
		System.out.println("[2] Exercise " );
		System.out.println("[3] Equipment " );
		System.out.println("[4] Group of exercises ");
		System.out.println("[5] Exit");
		
		int menuSelection = GetIntegerInput("", 1, 5);
		
		System.out.println("Menu selected: " + menuSelection);

		switch (menuSelection){
			case 1:
				return MenuItem.WORKOUT;
			case 2:
				return MenuItem.EXERCISE;
			case 3:
				return MenuItem.EQUIPMENT;
			case 4:
				return MenuItem.GROUP_OF_EXERCISES;
			case 5:
				return MenuItem.EXIT;
		}
		
		
	}
	

}