
public enum Workout {
	Pushups(6, 3), Pullups(5, 5), Squats(2, 2), Rowing(6, 6), IndoorSpinning(5, 7), Aerobics(2, 3), Running(8, 4);

	int stamina;
	int strength;

	private Workout(int stamina, int strength) {
		this.stamina = stamina;
		this.strength = strength;
	}
}

