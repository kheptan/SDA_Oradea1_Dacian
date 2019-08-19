import java.util.Random;

public class RandomChar {
	private static final int MAXIM = 60;
	private static final int MINIM = 1;
	private static final int FIRSTCHAR = 10;
	private static final int RADIX = 35;

	public static void main(String[] args) {
		String[] arr = createStringArray();
		String bigString = biggest(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("---------------------------------");
		System.out.println("Biggest string is: " + bigString);
	}

	private static int randomStringLength() {
		Random rd = new Random();
		return rd.ints(MINIM, MAXIM).boxed().findFirst().get().intValue();
	}

	private static String randomChar() {
		Random rd = new Random();
		StringBuilder sb = new StringBuilder();
		int length = randomStringLength();

		int[] codes = rd.ints(length, FIRSTCHAR, RADIX).toArray();

		for (int i = 0; i < codes.length; i++) {
			sb.append(Character.forDigit(codes[i], RADIX));
			// System.out.println();
		}
		return sb.toString();
	}

	private static String[] createStringArray() {
		int i = 0;
		String[] arrStr = new String[5];

		while (i < 5) {
			arrStr[i] = randomChar();
			i++;
		}
		return arrStr;
	}

	private static String biggest(String[] s) {
		int big = s[0].length();
		int pos = 0;
		for (int i = 1; i < s.length; i++) {
			if (big < s[i].length()) {
				big = s[i].length();
				pos = i;
			}
		}
		return s[pos];
	}
}