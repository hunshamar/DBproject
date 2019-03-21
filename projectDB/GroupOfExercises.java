package projectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GroupOfExercises {

		private int GroupID;
		private String name;
		
		

		public GroupOfExercises(String name) throws Exception{
			
			this.name = name;
			
			Driver driver = new Driver();
			int ID = driver.myStat.executeUpdate("INSERT INTO GroupOfExercises VALUES (default, "+ name+")", Statement.RETURN_GENERATED_KEYS); // Create!
			this.GroupID = ID;
			
			driver.myConn.close();
			
		}
		

		
	public void delGroupEx(int groupID) throws Exception{
		
		Driver driver = new Driver();
		driver.myStat.executeUpdate("DELETE FROM GroupOfExercises WHERE groupID =" + groupID); // Delete!
		driver.myConn.close();
	}
	
	public void editGroupEx(int groupID, String name) throws SQLException{
		this.name = name;
		Driver driver = new Driver();	
		driver.myStat.executeUpdate("UPDATE GroupOfExercises SET groupName = "+name +" WHERE groupID =" + groupID);
		driver.myConn.close();
	}
	
	
	public static void printGroupOfExercises(int ID){
		try {
    		Connection myConn = DriverManager.getConnection(Driver.url, Driver.username, Driver.password);
			// 2. Create a statement
			Statement myStat = myConn.createStatement();
		    ResultSet myRs = myStat.executeQuery("SELECT * FROM GroupOfExercises where groupID = "+ID);
		    while(myRs.next()){
				System.out.println("GroupOfExercises ID: "+myRs.getString("groupID"));
				System.out.println("    with Name: "+myRs.getString("groupName"));
            }
            System.out.println();
			
	    	myConn.close();
            }
    
	    catch (Exception e) {
		    e.printStackTrace();
	    }
    }
	
	public static void printAllGroupOfExercises(){
		try {
    		Connection myConn = DriverManager.getConnection(Driver.url, Driver.username, Driver.password);
			// 2. Create a statement
			Statement myStat = myConn.createStatement();
		    ResultSet myRs = myStat.executeQuery("SELECT * FROM GroupOfExercises");

		    while(myRs.next()){
				System.out.println("GroupOfExercises ID: "+myRs.getString("groupID"));
				System.out.println("    with Name: "+myRs.getString("groupName"));
            }
            System.out.println();
			
	    	myConn.close();
            }
    
	    catch (Exception e) {
		    e.printStackTrace();
	    }
    } 

}
