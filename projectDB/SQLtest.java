package projectDB;

import java.sql.*;

public class SQLtest {
	// private static final String driver = "com.mysql.jdbc.Driver";
	private static final String db_name = "workoutProgram";
	private static final String url = "jdbc:mysql://localhost:3306/" + db_name +  "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String username = "root";
	private static final String password = "password";
	
	public static void main(String[] args) {
				
try{
            printAllWorkouts();
            
            System.out.println("Now to print on id 123");

            printWorkout(123);


            //delWorkout(123);

            printAllWorkouts();
            

            printAllNotes();

            printNoteForWorkout(123);

            printAllEquiptment();

            printEquiptment(12);

            printAllExercises();

            printExercise(56);

            printAllWorkoutExercises();
            printWorkoutExercises(2);

            
        }


  catch (Exception e) {
    e.printStackTrace();
}

           // Driver driver = new Driver();
            //driver.myStat.executeUpdate
		
	}
	public static void printAllWorkouts(){
		try {
    		Connection myConn = DriverManager.getConnection(url, username, password);
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



    public static void printWorkout(int ID){
        try {
    		Connection myConn = DriverManager.getConnection(url, username, password);
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
	public static void printAllNotes(){
		try {
    		Connection myConn = DriverManager.getConnection(url, username, password);
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
    
    public static void printNoteForWorkout(int workoutID){
		try {
    		Connection myConn = DriverManager.getConnection(url, username, password);
			// 2. Create a statement
			Statement myStat = myConn.createStatement();
		    ResultSet myRs = myStat.executeQuery("SELECT * FROM note WHERE workoutID ="+workoutID);
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
    
    public static void printAllEquiptment(){
		try {
    		Connection myConn = DriverManager.getConnection(url, username, password);
			// 2. Create a statement
			Statement myStat = myConn.createStatement();
		    ResultSet myRs = myStat.executeQuery("SELECT * FROM Equipment");
		    while(myRs.next()){
				System.out.println("Equipment ID: "+myRs.getString("EquipmentID"));
				System.out.println("	Name of equipment: "+myRs.getString("NameEq"));
				System.out.println("	Description:" +myRs.getString("DescriptionEq"));
            }
            System.out.println();
			
	    	myConn.close();
            }
    
	    catch (Exception e) {
		    e.printStackTrace();
	    }
    } 

    public static void printEquiptment(int ID){
		try {
    		Connection myConn = DriverManager.getConnection(url, username, password);
			// 2. Create a statement
			Statement myStat = myConn.createStatement();
		    ResultSet myRs = myStat.executeQuery("SELECT * FROM Equipment where EquipmentID = " + ID);
		    while(myRs.next()){
				System.out.println("Equipment ID: "+myRs.getString("EquipmentID"));
				System.out.println("	Name of equipment: "+myRs.getString("NameEq"));
				System.out.println("    Description:" +myRs.getString("DescriptionEq"));
            }
            System.out.println();
			
	    	myConn.close();
            }
    
	    catch (Exception e) {
		    e.printStackTrace();
	    }
    } 


    public static void printAllExercises(){
		try {
    		Connection myConn = DriverManager.getConnection(url, username, password);
			// 2. Create a statement
			Statement myStat = myConn.createStatement();
		    ResultSet myRs = myStat.executeQuery("SELECT * FROM Exercise");
		    while(myRs.next()){
				System.out.println("Exercise ID: "+myRs.getString("ExerciseID"));
				System.out.println("    with equipment with ID : "+myRs.getString("EquipmentID"));
                System.out.println("    Body part: " +myRs.getString("BodyPart"));
                System.out.println("    Name of exercise: "+myRs.getString("NameEx"));
                System.out.println("    description of exercise: "+myRs.getString("DescriptionEx"));
            }
            System.out.println();
			
	    	myConn.close();
            }
    
	    catch (Exception e) {
		    e.printStackTrace();
	    }
    } 

    
    public static void printExercise(int ID){
		try {
    		Connection myConn = DriverManager.getConnection(url, username, password);
			// 2. Create a statement
			Statement myStat = myConn.createStatement();
		    ResultSet myRs = myStat.executeQuery("SELECT * FROM Exercise where ExerciseID = "+ID);
		    while(myRs.next()){
				System.out.println("Exercise ID: "+myRs.getString("ExerciseID"));
				System.out.println("    with equipment with ID : "+myRs.getString("EquipmentID"));
                System.out.println("    Body part: " +myRs.getString("BodyPart"));
                System.out.println("    Name of exercise: "+myRs.getString("NameEx"));
                System.out.println("    description of exercise: "+myRs.getString("DescriptionEx"));
            }
            System.out.println();
			
	    	myConn.close();
            }
    
	    catch (Exception e) {
		    e.printStackTrace();
	    }
    }
    


    public static void printAllWorkoutExercises(){
		try {
    		Connection myConn = DriverManager.getConnection(url, username, password);
			// 2. Create a statement
			Statement myStat = myConn.createStatement();
		    ResultSet myRs = myStat.executeQuery("SELECT * FROM WorkoutExercises");
		    while(myRs.next()){
				System.out.println("workout-exercise ID: "+myRs.getString("WEID"));
				System.out.println("    Workout ID : "+myRs.getString("WorkoutID"));
                System.out.println("    Exercise ID : " +myRs.getString("ExerciseID"));
                System.out.println("    Repetitions "+myRs.getString("Repetitions"));
                System.out.println("    Performance: "+myRs.getString("PerformanceRate"));
                System.out.println("    Number of kg: "+myRs.getString("NumbKilos"));
                System.out.println("    Number of sets: "+myRs.getString("Sets"));
                System.out.println("    Personal shape: "+myRs.getString("PersonalShape"));
            }
            System.out.println();
			
	    	myConn.close();
            }
    
	    catch (Exception e) {
		    e.printStackTrace();
	    }
    } 

    public static void printWorkoutExercises(int ID){
		try {
    		Connection myConn = DriverManager.getConnection(url, username, password);
			// 2. Create a statement
			Statement myStat = myConn.createStatement();
		    ResultSet myRs = myStat.executeQuery("SELECT * FROM WorkoutExercises where WEID ="+ID);
		    while(myRs.next()){
				System.out.println("workout-exercise ID: "+myRs.getString("WEID"));
				System.out.println("    Workout ID : "+myRs.getString("WorkoutID"));
                System.out.println("    Exercise ID : " +myRs.getString("ExerciseID"));
                System.out.println("    Repetitions "+myRs.getString("Repetitions"));
                System.out.println("    Performance: "+myRs.getString("PerformanceRate"));
                System.out.println("    Number of kg: "+myRs.getString("NumbKilos"));
                System.out.println("    Number of sets: "+myRs.getString("Sets"));
                System.out.println("    Personal shape: "+myRs.getString("PersonalShape"));
            }
            System.out.println();
			
	    	myConn.close();
            }
    
	    catch (Exception e) {
		    e.printStackTrace();
	    }
    } 

    


    



}



    
