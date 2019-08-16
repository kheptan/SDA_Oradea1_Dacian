import java.util.Scanner;

public class MainController {
    private Scanner scanner;
	private Supliments supliments;
	private Trainer trainer;
	private Trainee trainee;

	public void initScanner() {
		scanner = Utils.getScanner();
	}

	public void closeScanner() {
		scanner.close();
	}

	private void initSupliments() {
		if (supliments == null) {
			supliments = new Supliments(scanner);
		}
	}

	private void initTrainer() {
		if (trainer == null) {
			trainer = new Trainer("George", scanner);
		}
	}

	private void initTrainee() {
		if (trainee == null) {
			trainee = new Trainee("SamBennet");
		}
	}
    //initialise main application classes
	public void initApp() {
		initScanner();
		initSupliments();
		initTrainer();
		initTrainee();
	}

	public Supliments getSupliments() {
		return supliments;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public Trainee getTrainee() {
		return trainee;
	}

	public Scanner getS() {
		return scanner;
	}
}
