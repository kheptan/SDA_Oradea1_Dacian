package ro.sda.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ro.sda.classes.Actions;
import ro.sda.classes.Menu;
import ro.sda.classes.Tweet;
import ro.sda.classes.User;

public class AppManager {

	private static List<User> userList;
	private static HashMap<Tweet, User> tweetList;

	private static boolean quit = false;

	public void showMenu() {
		Menu.createMenu();
		Menu.showMenu();
	}

	public void itemAction() {
		int item = pickItem();
		doAction(item);
	}

	private int pickItem() {
		return Menu.itemSelected();
	}

	private void doAction(int action) {
		executeAction(action);
		checkQuiting(action);
	}

	private void checkQuiting(int action) {
		if (action == 5) {
			quit = true;
		}
	}

	public boolean quit() {
		return quit;
	}

	private void executeAction(int action) {
		switch (action) {
		case 1:
			newUser(getUsers());
			break;
		case 2:
			newMessage(getUsers());
			break;
		case 3:
			showTweets(getTweets(), getUsers());
			break;
		case 4:
			searchTweet(getTweets());
			break;
		case 5:
			quitMenu();
			break;
		}
	}

	private void newUser(List<User> user) {
		getUsers().add(Actions.addUser(user));
	}

	private void newMessage(List<User> users) {
		User user = Actions.selectUser(users);
		if (user != null) {
			Tweet tweet = Actions.addTweet();
			getTweets().put(tweet, user);
		} else {
			System.out.println("Add a user first!!!");
		}
	}

	private void showTweets(HashMap<Tweet, User> tweets, List<User> users) {
		Actions.getUserTweet(tweets, users);
	}

	private void searchTweet(HashMap<Tweet, User> tweets) {
		Actions.searchInMessage(tweets);
	}

	private void quitMenu() {
		Actions.quit();
	}

	private List<User> getUsers() {
		if (userList == null) {
			return userList = new ArrayList<User>();
		} else {
			return userList;
		}
	}

	private HashMap<Tweet, User> getTweets() {
		if (tweetList == null) {
			return tweetList = new HashMap<Tweet, User>();
		} else {
			return tweetList;
		}
	}
}
