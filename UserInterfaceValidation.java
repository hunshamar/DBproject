package projectDB;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class UserInterfaceValidation {
	
	static Scanner myScanner = new Scanner(System.in);
	
	public static boolean isValidInteger(int value, int lowerBound, int upperBound)
	{
		if (lowerBound <= value & value <= upperBound)
		{
			return true;
		}
		return false;
	}
	
	public static int GetIntegerInput(String question, int lowerBound, int upperBound)
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

	public static String GetStringInput(String question, int maxLength) {
		return  GetStringInput(question, maxLength, 0);
	}
	public static String GetStringInput(String question, int maxLength, int minLength)
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
	
	// Remember to 
	public static String GetConfirmation(String question)
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
			
			if (isValidConfirmation(input))
			{
				validInput = true;
			}
			counter++;
		}
		while(!validInput);
		
		
		return input;
	}
	
	public static boolean isValidConfirmation(String input)
	{
		if (input.length() == 1)
		{
			if (input.charAt(0) == 'y' || input.charAt(0) == 'n')
			{
				return true;
			}
		}
		return false;
	}
	
	public static boolean isConfirmation(String input)
	{
		if (input.charAt(0) == 'y')
		{
			return true;
		}
		return false;
	}
	
	public static String GetDateInput(String question)
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
		

		return input;
	}
	
	public static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }
	
	private static boolean isValidIntegerInput(int input, ArrayList<Integer> validIntegers)
	{
		
		int counter = 0;
		
		for (int i = 0; i < validIntegers.size(); i++)
		{
			if (input == validIntegers.get(i))
			{
				counter++;
			}
		}
		
		if (counter == 0)
		{
			System.out.println("Invalid list input entered");
			
			String validInput = "";
			
			for (int k = 0; k < validIntegers.size(); k++)
			{
				validInput += validIntegers.get(k) + ", ";
			}
			
			System.out.println("List of valid input: " + validInput);
			
			
			return false;
		}
		

	
		return true;
	}
	
	public static boolean isValidListInput(ArrayList<Integer> inputIntegerList, ArrayList<Integer> validIntegers)
	{
		for (int i = 0; i < inputIntegerList.size(); i++)
		{
			int counter = 0;
			
			for (int j = 0; j < validIntegers.size(); j++)
			{
				if (inputIntegerList.get(i).equals(validIntegers.get(j)))
				{
					counter++;
				}
			}
			
			if (counter == 0)
			{
				System.out.println("Invalid list input entered");
				
				String validInput = "";
				
				for (int k = 0; k < validIntegers.size(); k++)
				{
					validInput += validIntegers.get(k) + ", ";
				}
				
				System.out.println("List of valid input: " + validInput);
				
				
				return false;
			}
		}

		System.out.println("Valid list input");
		return true;
	}
	
	public static ArrayList<Integer> stringToIntegerList(String input)
	{
		String integer = "";
		
		ArrayList<Integer> integerList = new ArrayList<Integer>();
		
		for (int i = 0; i < input.length(); i++) {
			char index = input.charAt(i);
			
			if (Character.isDigit(index))
			{
				integer += index;
				
				if (i == input.length() - 1)
				{
					integerList.add(StringToInt(integer));
					
					integer = "";
				}
			}
			else if (index == ',')
			{
				integerList.add(StringToInt(integer));
				
				integer = "";
			}
		}
		
		return integerList;
		
	}
	
	public static int StringToInt(String input)
	{
		return Integer.parseInt(input);
	}

	
	public static ArrayList<Integer> GetIntegerListInput(String question, ArrayList<Integer> validIntegers)
	{
		boolean validInput= false;
		
		int counter = 0;
		
		String input = "";
		
		ArrayList<Integer> integerList = new ArrayList<Integer>();
		
		do {
			if (counter != 0)
			{
				System.out.println("That input was not valid, please try again.");
			}
			System.out.println(question);
			input = myScanner.nextLine();
			
			integerList = stringToIntegerList(input);
			
			if (isValidListInput(integerList, validIntegers))
			{
				validInput = true;
			}
			counter++;
		}
		while(!validInput);
		
		return integerList;
		
	}
	
	public static int GetIntegerInput(String question, ArrayList<Integer> validIntegers)
	{
		boolean validInput= false;
		int input = 0;
		
		do {
			
			System.out.println(question);
			try {
				input = myScanner.nextInt();
				
				if (isValidIntegerInput(input, validIntegers))
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

}
