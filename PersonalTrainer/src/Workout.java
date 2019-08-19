
public enum Workout {
	Pushups(4, 4), Pullups(4, 5), Squats(2, 2), Rowing(-6, 6), IndoorSpinning(-8, 7), Aerobics(2, 3), Running(-8, 4);

	private int stamina;
	private int strength;

	private Workout(int stamina, int strength) {
		this.stamina = stamina;
		this.strength = strength;
	}

	public int getStamina() {
		return stamina;
	}

	public int getStrength() {
		return strength;
	}
}

