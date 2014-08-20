package com.edison.pi.calculation.service.impl;

import org.junit.Assert;

import com.edison.pi.calculation.service.PiCalculationService;

/**
 * This is another implementation for PiCalculationService
 * @author Edison Yang
 * @date 2014-08-10
 */
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
		Assert.assertTrue("parameter number of terms can't be negtive as " + numberOfTerms, numberOfTerms >= 0);

		double result = doCalculate(numberOfTerms);
		result = derivePi(result);
		return result;
	}
	
	private double doCalculate(int numberOfTerms) {
		double var = 0;
		for (; numberOfTerms >= 0; numberOfTerms--) {
		var = var + Math.pow(-1, numberOfTerms) / (2d * numberOfTerms + 1);
	}
		return var;
	}

	private double derivePi(double result) {
		return result * 4;
	}

}
