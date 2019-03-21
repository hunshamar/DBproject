package projectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Equipment {

	
	
	private int EquipmentID;
	private String name;
	private String description ;
	
	public Equipment(String name, String description) throws Exception{
		this.setName(name);
		this.setDescription(description);
		
		Driver driver = new Driver();
		int ID = driver.myStat.executeUpdate("INSERT INTO Equipment VALUES (default,"+ this.name +","+ 
												this.description +")", Statement.RETURN_GENERATED_KEYS);
		this.setEquipmentID(ID);
	}
	
	
	private void setEquipmentID(int EquipmentID){
		this.EquipmentID = EquipmentID;
	}
	
	private void setName(String name){
		this.name = name;
	}
	private void setDescription(String description){
		this.description = description;
	}
	
	
	public int getEquipmentID() {
		return EquipmentID;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public String getDescription() {
		return description;
	}
		
		
	public static void printEquipment(int ID){
		try {
    		Connection myConn = DriverManager.getConnection(Driver.url, Driver.username, Driver.password);
			// 2. Create a statement
			Statement myStat = myConn.createStatement();
		    ResultSet myRs = myStat.executeQuery("SELECT * FROM Equipment where EquipmentID = "+ID);
		    while(myRs.next()){
				System.out.println("Equipment ID: "+myRs.getString("EquipmentID"));
				System.out.println("    with nameD : "+myRs.getString("NameEq"));
                System.out.println("    Description : " +myRs.getString("DescriptionEq"));
                }
            System.out.println();
			
	    	myConn.close();
            }
    
	    catch (Exception e) {
		    e.printStackTrace();
	    }
    }
	
	public void delEquipment(int equipmentID) throws Exception{
		
		Driver driver = new Driver();
		driver.myStat.executeUpdate("DELETE FROM Equipment WHERE equipmentID =" + equipmentID); // Delete!
		driver.myConn.close();
	}
	
	public void editEquipment(int equipmentID, String name, String description) throws SQLException{
		Driver driver = new Driver();	
		driver.myStat.executeUpdate("UPDATE Equipment SET nameEq = " +name + " , descriptionEq= "+description+ "  WHERE EquipmentID =" + equipmentID);
		driver.myConn.close();
	} 
	
	
	public static void printAllEquipment(){
		try {
    		Connection myConn = DriverManager.getConnection(Driver.url, Driver.username, Driver.password);
			// 2. Create a statement
			Statement myStat = myConn.createStatement();
		    ResultSet myRs = myStat.executeQuery("SELECT * FROM Equipment");

		    while(myRs.next()){
				System.out.println("Equipment ID: "+myRs.getString("EquipmentID"));
				System.out.println("    with nameD : "+myRs.getString("NameEq"));
                System.out.println("    Description : " +myRs.getString("DescriptionEq"));
                }
            System.out.println();
			
	    	myConn.close();
            }
    
	    catch (Exception e) {
		    e.printStackTrace();
	    }
    } 

		
	
}
