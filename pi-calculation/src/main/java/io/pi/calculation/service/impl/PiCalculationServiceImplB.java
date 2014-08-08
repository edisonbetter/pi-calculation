package io.pi.calculation.service.impl;

import org.junit.Assert;

import io.pi.calculation.service.PiCalculationService;

public class PiCalculationServiceImplB implements PiCalculationService {
	private int calculationTimes;
	
	public int getCalculationTimes() {
		return calculationTimes;
	}

	public void setCalculationTimes(int calculationTimes) {
		this.calculationTimes = calculationTimes;
	}

	@Override
	public double calculate(){
		Assert.assertTrue("parameter calculationTimes can't be negtive as " + calculationTimes, calculationTimes >= 0);

		double result = doCalculate(calculationTimes);
		result = derivePi(result);
		return result;
	}
	
	private double doCalculate(int calculationTimes) {
		double var = 0;
		for (int i = 0 ; i != calculationTimes; i++) {
			var = var + Math.pow(-1, i) / (2 * i + 1);
		}
		return var;
	}

	private double derivePi(double result) {
		return result * 4;
	}

}
