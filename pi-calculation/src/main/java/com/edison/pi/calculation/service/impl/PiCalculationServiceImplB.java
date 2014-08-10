package com.edison.pi.calculation.service.impl;

import org.junit.Assert;

import com.edison.pi.calculation.service.PiCalculationService;

public class PiCalculationServiceImplB implements PiCalculationService {
	private int numberOfTerms;
	
	@Override
	public int getNumberOfTerms() {
		return numberOfTerms;
	}

	@Override
	public void setNumberOfTerms(int numberOfTerms) {
		this.numberOfTerms = numberOfTerms;
	}

	@Override
	public double calculate(){
		Assert.assertTrue("parameter calculationTimes can't be negtive as " + numberOfTerms, numberOfTerms >= 0);

		double result = doCalculate(numberOfTerms);
		result = derivePi(result);
		return result;
	}
	
	private double doCalculate(int numberOfTerms) {
		double var = 0;
		for (int i = 0 ; i != numberOfTerms; i++) {
			var = var + Math.pow(-1, i) / (2 * i + 1);
		}
		return var;
	}

	private double derivePi(double result) {
		return result * 4;
	}

}
