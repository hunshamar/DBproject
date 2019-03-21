package projectDB;

public class Note {

	private int noteID;
	private String txt;
	private Workout workout;
	
	public Note(int noteID, Workout workout, String txt) throws Exception{
		this.setNoteID(noteID);
		this.setTxt(txt);
		this.setWorkout(workout);
		
		Driver driver = new Driver();
		driver.myStat.executeUpdate("INSERT INTO Note VALUES ("+ noteID +","+ workout +","+ txt); // Create!
		driver.myConn.close();
	}

	public int getNoteID() {
		return noteID;
	}

	public void setNoteID(int noteID) {
		this.noteID = noteID;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	public Workout getWorkout() {
		return workout;
	}

	public void setWorkout(Workout workout) {
		this.workout = workout;
	}
	
	
	
}