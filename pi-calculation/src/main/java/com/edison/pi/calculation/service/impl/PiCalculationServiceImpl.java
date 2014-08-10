package com.edison.pi.calculation.service.impl;

import org.junit.Assert;

import com.edison.pi.calculation.service.PiCalculationService;

/**
 * This is one implementation for Pi calculation 
 * 
 * @author Edison Yang
 *
 */
public class PiCalculationServiceImpl implements PiCalculationService {
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

	/**
	 * apply the formula to get approximate Pi/4
	 * 
	 * @param numberOfTerms
	 * @return
	 */
	private double doCalculate(int numberOfTerms) {
		double var = 0;
		for (; numberOfTerms >= 0; numberOfTerms--) {
			var = var + Math.pow(-1, numberOfTerms) / (2 * numberOfTerms + 1);
		}
		return var;
	}

	/**
	 * Get Pi/4 * 4 = Pi
	 * 
	 * @param result
	 * @return
	 */
	private double derivePi(double result) {
		return result * 4;
	}

}
