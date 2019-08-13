
public enum Workout {
	Pushups(3, 5), Pullups(3, 6), Squats(2, 2), Rowing(4, 5), IndoorSpinning(5, 7), Aerobics(2, 3), Running(6, 8);

	int burnout;
	int strength;

	private Workout(int burnout, int strength) {
		this.burnout = burnout;
		this.strength = strength;
	}
}
