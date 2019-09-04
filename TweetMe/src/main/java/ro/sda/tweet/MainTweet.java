package ro.sda.tweet;

import ro.sda.manager.AppManager;
import ro.sda.utils.ScannerUtils;

public class MainTweet {

	public static void main(String[] args) {
		AppManager app = new AppManager();
		while (!app.quit()) {
			app.showMenu();
			app.itemAction();
		}
		ScannerUtils.closeScanner();
	}
}
