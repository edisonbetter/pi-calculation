package io.pi.calculation;

public class PiCalculation {

	public double calculate(int n) throws Exception {
		if (n < 0) {
			throw new Exception("parameter n can't be negtive");
		}

		double result = doCalculate(n);
		double pi = derivePi(result);
		return pi;
	}

	private double doCalculate(int n) {
		double var = 0;
		for (; n >= 0; n--) {
			var = var + Math.pow(-1, n) / (2 * n + 1);
		}
		return var;
	}

	private double derivePi(double result) {
		return result * 4;
	}
}
