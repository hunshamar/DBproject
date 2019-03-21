package projectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercise {

	private int exerciseID;
	private String name;
	private String description;
	private String bodypart;
	private Equipment equi;
	
	
	public Exercise(String bodypart, String name, String description) throws Exception{
		
		this.setName(name);
		this.setDescription(description);
		this.setBodypart(bodypart);
		
		Driver driver = new Driver();
		int ID = driver.myStat.executeUpdate("INSERT INTO Exercise VALUES (default, "+ "null" +","+ 
		bodypart+","+ name +","+ description + ")", Statement.RETURN_GENERATED_KEYS); // Create!
		this.setExerciseID(ID);
		
		driver.myConn.close();
		
	}
	
	
	public Exercise(String name, String description, String bodypart, String equiName, String equiDesc) throws Exception{

		Equipment equipment = new Equipment(equiName, equiDesc);
		
		this.setEqui(equipment);
		
		this.setName(name);
		this.setDescription(description);
		this.setBodypart(bodypart);

			
		Driver driver = new Driver();
		int ID = driver.myStat.executeUpdate("INSERT INTO Exercise VALUES (default, "+ this.equi.getEquipmentID() +","+ 
										bodypart +","+name +","+ description +")", Statement.RETURN_GENERATED_KEYS); // Create!
				
		this.setExerciseID(ID);
		driver.myConn.close();
			
		
	}
	
	public void delExercise(int exerciseID) throws Exception{
		
			Driver driver = new Driver();
			driver.myStat.executeUpdate("DELETE FROM Exercise WHERE exerciseID =" + exerciseID); // Delete!
			driver.myConn.close();
	}
	
	public void editExercise(int exerciseID, String bodypart, String name, String description) throws SQLException{
		Driver driver = new Driver();	
		driver.myStat.executeUpdate("UPDATE Exercise SET BodyPart = " +bodypart + " , NameEx = "+name+ ", DescriptionEx = " + description+ "  WHERE ExerciseID =" + exerciseID);
		driver.myConn.close();
	} 
	
	
	public static void printExercise(int ID){
		try {
    		Connection myConn = DriverManager.getConnection(Driver.url, Driver.username, Driver.password);
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
	
	public static void printAllExercises(){
		try {
    		Connection myConn = DriverManager.getConnection(Driver.url, Driver.username, Driver.password);
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
	
	
	public void printEquiptment(){
		try {
    		Connection myConn = DriverManager.getConnection(Driver.url, Driver.username, Driver.password);
			// 2. Create a statement
			Statement myStat = myConn.createStatement();
		    ResultSet myRs = myStat.executeQuery("SELECT * FROM Equipment where EquipmentID = " + this.equi.getEquipmentID());
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
	
	public static void printAllEquiptment(){
		try {
    		Connection myConn = DriverManager.getConnection(Driver.url, Driver.username, Driver.password);
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
	
	
	
	public int getExerciseID() {
		return exerciseID;
	}
	public void setExerciseID(int exerciseID) {
		this.exerciseID = exerciseID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Equipment getEqui() {
		return equi;
	}
	public void setEqui(Equipment equi) {
		this.equi = equi;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBodypart() {
		return bodypart;
	}
	public void setBodypart(String bodypart) {
		this.bodypart = bodypart;
	}
}
