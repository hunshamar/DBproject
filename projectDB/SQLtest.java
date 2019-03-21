package projectDB;

public class SQLtest {
	
	public static void main(String[] args) throws Exception {
			Workout work = new Workout("'2018-04-12'", "'1:20'", 1, 1, "'bla'");
			//work.delWorkout(5);
			//work.editWorkout(7, "'2019-04-12'", "'1:20'", 1, 1, "'bla'");
			Note.delNote(1);
			Note.editNote(2, "'this works'");
			
			Exercise ex = new Exercise("'Chest'", "'Bench'", "'Good exercise'");
			ex.delExercise(3);
			ex.editExercise(4, "'arms'", "'bench'", "'push weigth'");
			Equipment eq = new Equipment("'dumbell'", "'djfhjkdhf'");
			eq.delEquipment(3);
			eq.editEquipment(4, "'carbell'", "'this works 2 '");
			GroupOfExercises gE = new GroupOfExercises("'feet'");
			//gE.editGroupEx(3, "'arms'");
			//gE.delGroupEx(4);
			GroupOfExercises.printAllGroupOfExercises();
			Equipment.printAllEquipment();
			Exercise.printAllExercises();
			
			Workout.printAllWorkouts();
			
			Note.printAllNotes();
	}
}