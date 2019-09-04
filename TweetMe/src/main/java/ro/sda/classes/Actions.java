package ro.sda.classes;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ro.sda.utils.ScannerUtils;

public class Actions {

	public static User addUser(List<User> user) {
		return createUser(user, getUsername());
	}

	private static User createUser(List<User> user, String username) {
		// TO DO regEx username
		return createNewUser(user, username);
	}

	private static User createNewUser(List<User> user, String username) {
		return validateUser(user, username);
	}

	private static User validateUser(List<User> user, String username) {
		boolean isInList = user.stream().filter(u -> u.getUser().contentEquals(username)).findFirst().isPresent();
		if (isInList) {
			System.out.println("This user already exist, select another name");
			return createNewUser(user, getUsername());
		}
		else {
			return new User(username);
		}
	}

	public static User selectUser(List<User> users) {
		if (users.isEmpty()) {
			return null;
		}
		System.out.println("Select a username from list");
		listUser(users);
		String username = getUsername();
		User user = findUser(users, username);
		if (user != null) {
			return user;
		} else {
			System.out.println("User not found, try again");
			return selectUser(users);
		}
		
	}

	private static String getUsername() {
		System.out.printf("Enter a user name : ");
		String username = ScannerUtils.getNextString();
		if (regEx(username)) {
			return username;
		} else {
			System.out.println("User name can't be empty and should contains" + " only alphanumeric characters !!! ");
			return getUsername();
		}

	}

	private static User findUser(List<User> users, String username) {
		if (users.isEmpty()) {
			return null;
		} else if (users.stream().filter(u -> u.getUser().contentEquals(username)).findFirst().isPresent()) {
			return users.stream().filter(u -> u.getUser().contentEquals(username)).findFirst().get();
		} else {
			return null;
		}
	}

	private static String createMessage() {
		System.out.println("Enter a new message, max 140 characters! ");
		String s = ScannerUtils.getNextString();
		if (s.length() > 140 || s.length() < 1) {
			System.out.println("Message should contain between 1 and 140 characters");
			return createMessage();
		} else {
			return s;
		}
	}

	public static Tweet addTweet() {
		return addNewTweet();
	}

	public static Tweet addNewTweet() {
		String message = createMessage();
		return new Tweet(message);
	}

	public static void getUserTweet(HashMap<Tweet, User> tweets, List<User> users) {
		if (tweets.isEmpty()) {
			System.out.println("There are no tweets, please add some !!!");
			return;
		}
		User tweetUser = selectUser(users);
		if (tweetUser != null) {
			showAllTweets(tweets, tweetUser);
		} else {
			System.out.println("");
		}
	}

	private static void showAllTweets(HashMap<Tweet, User> tweets, User user) {
		System.out.println("\nDisplay all tweets for user : " + user.getUser());
		User tweetUser = findUserInTweet(tweets, user);
		if (tweetUser == null) {
			System.out.println("There are no tweets in the list, add some tweets first!");
		} else {
			tweets.entrySet().stream().filter(e -> e.getValue().getUser().contentEquals(user.getUser()))
				.forEach(tweet -> System.out.println(tweet.getKey().getTweet()));
		}
	}

	private static User findUserInTweet(HashMap<Tweet, User> tweets, User user) {
		if (tweets.isEmpty()) {
			return null;
		} else {
			return tweets.entrySet().stream().filter(e -> e.getValue().getUser().contentEquals(user.getUser()))
					.findFirst().get()
					.getValue();
		}
	}

	public static void searchInMessage(HashMap<Tweet, User> tweets) {
		if (tweets.isEmpty()) {
			System.out.println("There are no tweets in the list to look for!!!");
			return;
		}
		tweetLookup(tweets, keywordSearch());
	}

	private static String keywordSearch() {
		System.out.println("Search for : ");
		return ScannerUtils.getNextString();
	}

	private static void tweetLookup(HashMap<Tweet, User> tweets, String keyword) {
		if (keyword.isEmpty()) {
			System.out.println("String is empty");
			return;
		}
		boolean keywordFound = tweets.entrySet().stream().filter(e -> e.getKey().getTweet().contains(keyword))
				.findFirst().isPresent();
		if (keywordFound)
			tweets.entrySet().stream().filter(e -> e.getKey().getTweet().contains(keyword)).forEach(e -> {
				System.out.println("Found ->" + keyword + "<- in \"" + e.getKey().getTweet() + "\" user "
						+ e.getValue().getUser() + " tweet");
			});
		else
			System.out.println("No string was found...");
	}

	public static void quit() {
		System.out.println("quiting");
	}

	public static void listUser(List<User> users) {
		users.stream().forEach(u -> System.out.print(u.getUser() + " , "));
		System.out.println("\n");
	}

	// only alphanumeric characters
	private static boolean regEx(String str) {
		String regex = "^[a-zA-Z0-9]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

}
