public class MainTrainer {
	
	public static void main(String[] args) {
		//init controller
		MainController mc = new MainController();
		mc.initApp();
        
		//make new instances  
		Trainee trainee = mc.getTrainee();
		Trainer trainer = mc.getTrainer();
		Supliments supliments = mc.getSupliments();
		
		//trainee warmup before workout
		trainee.warmUp();
		
		// keep workout until trainee quits
		// infinitive loop
		while (true) {
			//trainer shows the workout lists
			Workout workout = trainer.pickUpWorkout();
			
			//before any workout check stamina level
			//and add supliments if need it
			if (trainee.checkStaminaLevel(workout)) {
				System.out.println("Stamina level is looow, you should take some supliments..");
				trainee.takeSupliment(supliments.showMenu());
			} else {
				trainee.doWorkout(workout);
			}
			
			System.out.println("Continue with workouts ? Press C for continue or Q for quiting workout");
			mc.getS().hasNext();
			char result = mc.getS().next().charAt(0);
			//continue or quit the workout
			if (trainer.nextWorkout(result)) {
				continue;
			} else {
				System.out.println("Your stamina level is at: " + trainee.getStamina() + " and your strength is at :"
						+ trainee.getStrength());
				break;
			}
		}
		trainee.coolDown();
		mc.closeScanner();
	}
}
