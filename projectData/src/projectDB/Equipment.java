package projectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Equipment {
	
	private int EquipmentID;
	private String name;
	private String description;
	
	public Equipment(String name, String description)
	{
		this.name = name;
		this.description = description;
	
	}
	
	public Equipment()
	{
		
	}
	
	public void CreateEquipmentInDatabase()
	{
		Driver driver;
		try {
			driver = new Driver();
			
			driver.myStat.executeUpdate("INSERT INTO Equipment VALUES (default,'"+ this.name +"','"+ 
					this.description +"')", Statement.RETURN_GENERATED_KEYS);
			
			// Get the EquipmentID from the Database
			ResultSet rs = driver.myStat.getGeneratedKeys();
			int autoIncKeyFromApi= 0;
		    if (rs.next()) {
		        autoIncKeyFromApi = rs.getInt(1);
		    } else {

		        // throw an exception from here
		    }
		    
		    this.EquipmentID = autoIncKeyFromApi;
		    
			driver.myConn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public static void DeleteEquipment(int equipmentID) throws Exception{
		
		Driver driver = new Driver();
		driver.myStat.executeUpdate("DELETE FROM Equipment WHERE equipmentID =" + equipmentID); // Delete!
		driver.myConn.close();
	}
	
	public static void editEquipment(int equipmentID, String name, String description) throws SQLException{
		Driver driver = new Driver();	
		driver.myStat.executeUpdate("UPDATE Equipment SET nameEq = " +name + " , descriptionEq= "+description+ "  WHERE EquipmentID =" + equipmentID);
		driver.myConn.close();
	} 
	
	
	public static void printAllEquipment(){
		
    } 
	
	
	public void setEquipmentID(int EquipmentID){
		this.EquipmentID = EquipmentID;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setDescription(String description){
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
		
		
	

		
	
}