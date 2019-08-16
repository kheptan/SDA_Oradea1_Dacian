import java.util.Scanner;

public class Supliments {
	Scanner scanner;

	public Supliments(Scanner scanner) {
		this.scanner = scanner;
	}

	public int suplimentsMenu() {
		showMenu();
		return pickSupliment();
	}

	public int showMenu() {
		System.out.println("Choose one supliemnt from this list\n");
		for (Supliment s : Supliment.values()) {
			System.out.println("Push key " + s.ordinal() + " for -> " + s.name());
		}
		return pickSupliment();
	}

	private int pickSupliment() {
		int supliment;
		while (true) {
			supliment = scanner.nextInt();
			if (supliment > Supliment.values().length - 1 || supliment < 0) {
				System.out.println("Choose a correct number between 0 and " + (Supliment.values().length - 1));
				continue;
			} else {
				break;
			}
		}
		System.out.println(
				"You've choosed " + Supliment.values()[supliment].name());
		return Supliment.values()[supliment].stamina;
	}


}
