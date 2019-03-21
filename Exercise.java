package projectDB;

public class Exercise {

	private int exerciseID;
	private String name;
	private String description;
	private String bodypart;
	private Equipment equi;
	
	
	public Exercise(String name, String description, String bodypart) throws Exception{
		
		this.setName(name);
		this.setDescription(description);
		this.setBodypart(bodypart);
		
		Driver driver = new Driver();
		driver.myStat.executeUpdate("INSERT INTO WithoutEquipment VALUES ("+ name +","+ bodypart +","+ description); // Create!
		
		//int ExerciseID = driver.myStat.getLatestWorkout; <-- Firgure out what to use here
		this.setExerciseID(exerciseID);
		
		driver.myConn.close();
		
	}
	
	
	public Exercise(String name, String description, String bodypart, Equipment equi) throws Exception{

		this.setName(name);
		this.setEqui(equi);
		this.setDescription(description);
		this.setBodypart(bodypart);

			
		Driver driver = new Driver();
		driver.myStat.executeUpdate("INSERT INTO WithEquipment VALUES ("+ name +","+ bodypart +","+ description + "," + equi); // Create!
				
		//int exerciseID = driver.myStat.RETURN_GENERATED_KEYS; //<-- Firgure out what to use here
		this.setExerciseID(exerciseID);
		
		driver.myConn.close();
			
		
	}
	
	public void delExercise(int exerciseID, boolean type) throws Exception{
		
		if(type == true) {
			Driver driver = new Driver();
			driver.myStat.executeUpdate("DELETE FROM WithEquipment WHERE exerciseID =" + exerciseID); // Delete!
			driver.myConn.close();
		}
		else {
			Driver driver = new Driver();
			driver.myStat.executeUpdate("DELETE FROM WithoutEquipment WHERE exerciseID =" + exerciseID); // Delete!
			driver.myConn.close();
		}
	}
	
	public void showExercise(int exerciseID, boolean type) throws Exception{
		
		if(type == true) {
			Driver driver = new Driver();
			driver.myStat.executeQuery("SELECT * FROM WithEquipment WHERE exerciseID =" + exerciseID); //Query!!			
			driver.myConn.close();
		}
		else {
			Driver driver = new Driver();
			driver.myStat.executeQuery("SELECT * FROM WithoutEquipment WHERE exerciseID =" + exerciseID); //Query!!			
			driver.myConn.close();
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
