package projectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EquipmentManager {
	
	private static ArrayList<Equipment> listOfEquipment = new ArrayList<Equipment>();

	
	public static void CreateEquipment(String name, String description)
	{
		Equipment equipment = new Equipment(name, description);
		
		equipment.CreateEquipmentInDatabase();
	}
	
	public static void PrintAllEquipment()
	{
		try {
    		Connection myConn = DriverManager.getConnection(Driver.url, Driver.username, Driver.password);
			// 2. Create a statement
			Statement myStat = myConn.createStatement();
		    ResultSet myRs = myStat.executeQuery("SELECT * FROM Equipment");

		    while(myRs.next()){
				System.out.println("Equipment ID: "+myRs.getString("EquipmentID"));
				System.out.println("with name : "+myRs.getString("NameEq"));
                System.out.println("Description : " +myRs.getString("DescriptionEq"));
                }
            System.out.println();
			
	    	myConn.close();
            }
    
	    catch (Exception e) {
		    e.printStackTrace();
	    }
	}
	
	private static void UpdateListOfEquipment()
	{
		listOfEquipment.clear();
		
		try {
    		Connection myConn = DriverManager.getConnection(Driver.url, Driver.username, Driver.password);
			// 2. Create a statement
			Statement myStat = myConn.createStatement();
		    ResultSet myRs = myStat.executeQuery("SELECT * FROM Equipment");

		    while(myRs.next()){
		    	
		    	Equipment equipment = new Equipment();
		    	equipment.setEquipmentID(Integer.parseInt(myRs.getString("EquipmentID")));
		    	equipment.setName(myRs.getString("NameEq"));
		    	equipment.setDescription(myRs.getString("DescriptionEq"));
				
		    	listOfEquipment.add(equipment);
                }
			
	    	myConn.close();
            }
    
	    catch (Exception e) {
		    e.printStackTrace();
	    }
	}
	
	public static ArrayList<Integer> GetListOfEquipmentIDs()
	{
		UpdateListOfEquipment();
		
		ArrayList<Integer> listOfEquipmentIDs = new ArrayList<Integer>();
		
		for (int i = 0; i < listOfEquipment.size(); i++)
		{
			listOfEquipmentIDs.add(listOfEquipment.get(i).getEquipmentID());
		}
		return listOfEquipmentIDs;
	}
}
