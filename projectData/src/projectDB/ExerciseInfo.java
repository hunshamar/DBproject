package projectDB;

public class ExerciseInfo {
	public int exerciseID;
	public int repetitions;
	public int performanceRate;
	public int numKilos;
	public int sets;
	public int  personalShape;
	
	public ExerciseInfo(int exerciseID, int repetitions, int performanceRate, int numKilos, int sets, int personalShape)
	{
		this.exerciseID = exerciseID;
		this.repetitions = repetitions;
		this.performanceRate = performanceRate;
		this.numKilos = numKilos;
		this.sets = sets;
		this.personalShape = personalShape;
		
	}
	
	

}