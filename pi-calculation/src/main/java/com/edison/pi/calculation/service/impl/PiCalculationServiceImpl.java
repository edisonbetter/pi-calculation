package com.edison.pi.calculation.service.impl;

import org.junit.Assert;

import com.edison.pi.calculation.service.PiCalculationService;

public class PiCalculationServiceImpl implements PiCalculationService {
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
		for (; calculationTimes >= 0; calculationTimes--) {
			var = var + Math.pow(-1, calculationTimes) / (2 * calculationTimes + 1);
		}
		return var;
	}

	private double derivePi(double result) {
		return result * 4;
	}

}
