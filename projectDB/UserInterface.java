package projectDB;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;  // Import the Scanner class

public class UserInterface {
	
	static Scanner myScanner;

	public static void main(String[] args) {
		

		
		State myState = State.Exercise;
		
		System.out.println(myState);




		UserInterface ui = new UserInterface();
		
		// TODO Auto-generated method stub
		System.out.println("Hello world");
		
		myScanner = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter username");

	    String userName = myScanner.nextLine();  // Read user input
	    System.out.println("Username is: " + userName);  // Output user input
	    
	    ui.DrawMainMenu();
	    
	    ui.DrawOptions("Workout");
	    
	    myScanner.close();
	}
	
	
	public MenuItem DrawMainMenu()
	{
		System.out.println("Main menu. Please select a sub menu:");
		
		System.out.println("\n[1]: Workouts  \n[2]: Exercises  \n[3]: Equipment \n[4]: Log");

		switch select{
			1:
				return MenuItem.Workouts
			2:
				return 
			3:

		}

		
	}
	
	
	public int DrawOptions(String menuName)
	{


		System.out.println();
		System.out.println(menuName + ": Please select an action");
		
		System.out.println("[1] View " + menuName);
		System.out.println("[2] Create new " + menuName);
		System.out.println("[3] Edit " + menuName);
		System.out.println("[4] Delete " + menuName);
		System.out.println("[5] Exit to main menu");
		
		int menuSelection = GetIntegerInput("", 1, 5);
		
		System.out.println("Menu selected: " + menuSelection);
		
		if (menuSelection == 2)
		{
			CreateWorkout();
		}
		return menuSelection;
	}
	
	public void CreateWorkout()
	{
		String name = GetStringInput("Enter name: (Must be less than 40 characters)", 40);

	    int personalShape = GetIntegerInput("Enter Personal Shape: (An integer between 1 and 10)", 1, 10);
	    
	  
	    Date date = GetDateInput("Enter date 'dd-MM-yyyy HH:mm'");
		
		
		
		
		
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		
	}
	
	
	
	public void viewExercises(){
		// Goes through sql and prints all exersises in a nice way

	}

	
	public boolean isValidInteger(int value, int lowerBound, int upperBound)
	{
		if (lowerBound <= value & value <= upperBound)
		{
			return true;
		}
		return false;
	}
	
	public int GetIntegerInput(String question, int lowerBound, int upperBound)
	{
		boolean validInput= false;
		
		
		int input = 0;
		
		do {
			
			System.out.println(question);
			try {
				input = myScanner.nextInt();
				
				if (isValidInteger(input, lowerBound, upperBound))
				{
					validInput = true;
				}
			}
			catch (java.util.InputMismatchException e) {

				// To clear the scanner to avoid double input
				myScanner.nextLine();
			}
			if (!validInput) {
				System.out.println("That input was not valid, please try again.");

			}
		
		}
		while(!validInput);
		
	
		
		// To clear the scanner to avoid double input
		myScanner.nextLine();
		
		return input;
	
	}

	public String GetStringInput(String question, int maxLength) {
		return  GetStringInput(question, maxLength, 0);
	}
	public String GetStringInput(String question, int maxLength, int minLength)
	{
		boolean validInput= false;
		
		int counter = 0;
		
		String input = "";
		
		do {
			if (counter != 0)
			{
				System.out.println("That input was not valid, please try again.");
			}
			System.out.println(question);
			input = myScanner.nextLine();
			
			if (input.length() <= maxLength && input.length() >= minLength)
			{
				validInput = true;
			}
			counter++;
		}
		while(!validInput);
		
		return input;
	
	}
	
	public Date GetDateInput(String question)
	{
		boolean validInput= false;
		
		int counter = 0;
		
		String input = "";
		
		do {
			if (counter != 0)
			{
				System.out.println("That input was not valid, please try again.");
			}
			System.out.println(question);
			input = myScanner.nextLine();
			
			if (isValidDate(input))
			{
				validInput = true;
			}
			counter++;
		}
		while(!validInput);
		

		return new Date();
	}
	
	public static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
