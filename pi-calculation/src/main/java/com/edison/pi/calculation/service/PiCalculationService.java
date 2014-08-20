package com.edison.pi.calculation.service;

/**
 * This interface is for Pi calculation
 * 
 * @author Edison Yang
 * @date 2014-08-10 
 */
public interface PiCalculationService {
	/**
	 * calculation logic should be put here
	 * @return calculation result, approximation of Pi
	 */
	double calculate();
	
	/**
	 * get number of terms in the calculation formula
	 * 
	 */
	int getNumberOfTerms();
	
	/**
	 * set number of terms in the calculaton formula
	 * @param numberOfTerms
	 */
	void setNumberOfTerms(int numberOfTerms);
}
