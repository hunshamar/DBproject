package projectDB;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Workout {

	private int workoutID;
	private Date date;
	private Double length;
	private int personalShape;
	private int performance;
	private Note note;
	
	
	public Workout(Date date, Double length, int personalShape, int performance, String noteTxt) throws Exception{
		super();
		this.setDate(date);
		this.setLength(length);
		this.setPersonalShape(personalShape);
		this.setPerformance(performance);
		
		Driver driver = new Driver();
		int ID = driver.myStat.executeUpdate("INSERT INTO Workout VALUES ("+ date +","+
												length +","+ personalShape+ ","+ performance, Statement.RETURN_GENERATED_KEYS); // Create!
		this.setWorkoutID(ID);
		
		Note note = new Note(this, noteTxt);
		this.setNote(note);
		
		driver.myConn.close();

	}
	
	public void delWorkout(int workoutID) throws Exception{
		
		Driver driver = new Driver();
		driver.myStat.executeUpdate("DELETE FROM Workout WHERE workoutID =" + workoutID); // Delete!
		driver.myConn.close();
	}
	
	public ResultSet showWorkout(int workoutID) throws Exception{
		
		Driver driver = new Driver();
		ResultSet output = driver.myStat.executeQuery("SELECT * FROM Workout WHERE workoutID =" + workoutID); //Query!!
		driver.myConn.close();
		
		return output;
	}
	

	public int getWorkoutID() {
		return workoutID;
	}
	public void setWorkoutID(int workoutID) {
		this.workoutID = workoutID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
	public int getPersonalShape() {
		return personalShape;
	}
	public void setPersonalShape(int personalShape) {
		this.personalShape = personalShape;
	}
	public int getPerformance() {
		return performance;
	}
	public void setPerformance(int performance) {
		this.performance = performance;
	}
	public Note getNote() {
		return note;
	}
	public void setNote(Note note) {
		this.note = note;
	}
	
	
	
	
}
