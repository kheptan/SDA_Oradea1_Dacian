public class Calculator {
	boolean error = false;

	public int add(int a, int b) {
		return a + b;
	}

	public int sub(int a, int b) {
		return a - b;
	}

	public int addWithExcep(int a, int b) {
		int sum = a + b;

		if (sum == -1) {
			error = true;
			return 0;
		} else if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
			error = true;
			return 0;
		}
		return sum;
	}
}
