public class Calculator {

	public int add(int a, int b) {
		return a + b;
	}

	public int sub(int a, int b) {
		return a - b;
	}

	public int addWithExcep(int a, int b) {
		int sum = a + b;

		if (sum == -1) {
			return 0;
		} else if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE)
			return -1;

		return sum;
	}
}
