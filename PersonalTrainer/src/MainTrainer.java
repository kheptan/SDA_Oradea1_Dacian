
public class MainTrainer {

	private static final String QUIT = "quit";
	private static final String CONTINUE = "continue";

	private int strength = 50;
	private int stamina = 30;

	public static void main(String[] args) {
		MainController mc = new MainController();
		mc.initApp();
		boolean quiting = false;

		Trainee trainee = mc.getTrainee();
		Trainer trainer = mc.getTrainer();
		Supliments supliments = mc.getSupliments();
		trainee.warmUp();
		while (true) {
			Workout workout = trainer.pickUpWorkout();

			if (trainee.checkStaminaLevel(workout)) {
				System.out.println("Stamina level is looow, you should take some supliments..");
				trainee.takeSupliment(supliments.showMenu());
			} else {
				trainee.doWorkout(workout);
			}

			System.out.println("To continue press C or Q for quit");
			if (mc.getS().nextLine().equalsIgnoreCase("c")) {
				continue;
			} else if (mc.getS().nextLine().equalsIgnoreCase("q")) {
				System.out.println("Your stamina level is at: " + trainee.getStamina() + " and your strength is at :"
						+ trainee.getStrength());
				break;
			}
			
		}
		trainee.coolDown();
		mc.closeScanner();
	}

}
