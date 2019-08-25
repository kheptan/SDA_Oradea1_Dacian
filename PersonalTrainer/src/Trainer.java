import java.util.Scanner;

public class Trainer {
	private String name;
	private Scanner scanner;
	
	//constructor - init name
	public Trainer(String name, Scanner scanner) {
		this.name = name;
		this.scanner = scanner;
	}

	//let trainee choose an workout
	public Workout pickUpWorkout() {
		System.out.println("Hy, my name is " + this.name + " i'm your trainer for today");
		System.out.println("Choose one workout from this list\n");
		for (Workout w : Workout.values()) {
			System.out.println("Push key " + w.ordinal() + " for -> " + w.name());
		}
		return selectWorkout();
	}
	
	//ask trainee if he/she want to continue
	private Workout selectWorkout() {
		int workout;
		while (true) {
			workout = scanner.nextInt();
			if (workout > Workout.values().length - 1 || workout < 0) {
				System.out.println("Choose a correct number between 0 and "
			               + (Workout.values().length - 1));
				continue;
			} else {
				break;
			}
		}
		System.out.println(
				"You've choosed " + Workout.values()[workout].name());
		return Workout.values()[workout];
	}
	
	//ask trainee to continue workout or not
	public boolean nextWorkout(char response) {		
		if (response == 'c' || response == 'C') {
			return true;
		} else if (response == 'q' || response == 'Q') {
			return false;
		} else {
			System.out.println("Please choose between C (continue)  or Q (quit)");
			return nextWorkout(scanner.nextLine().charAt(0));
		}
	}
}
