
public class Trainee {
	private static final int STRENGTHLEVEL = 50;

	String name;
	int stamina = 0;
	int strength = 0;
	
	//constructor
	public Trainee(String name) {
		this.name = name;
	}
	
	// some warmup
	public void warmUp() {
		System.out.println("Warming up a bit..");
		setStamina(1);
		;
		setStrength(1);
	}

	// some cooldown
	public void coolDown() {
		System.out.println("Cool down a bit..");
		setStamina(10);
		setStrength(10);
	}
	//do workout()
	public void doWorkout(Workout work) {
		workout(work);
	}

	private void workout(Workout work) {
		if (checkStrengthLevel()) {
			decreaseStrength();
		}

		this.stamina = this.stamina + work.getStamina();
		this.strength = this.strength + work.getStrength();
	}
	
	public boolean checkStaminaLevel(Workout work) {
		if ((stamina + work.getStamina()) <= 2) {
			return true;
		}else {
			return false;
		}
	}

	private boolean checkStrengthLevel() {
		int level = Math.abs((this.strength / STRENGTHLEVEL) * 100);
		if (level >= 90) {
			return true;
		}
		return false;
	}

	private void decreaseStrength() {
		this.strength = STRENGTHLEVEL - (this.strength + (int) (this.strength * 0.5));
		System.out.println("I decreased strength to a lower level");
	}

	public int getStamina() {
		return stamina;
	}

	public int getStrength() {
		return strength;
	}

	public void setStamina(int st) {
		stamina = stamina + st;
	}

	public void setStrength(int str) {
		strength = strength + str;
	}

	public void takeSupliment(int supliment) {
		this.stamina = this.stamina + supliment;
	}
}
