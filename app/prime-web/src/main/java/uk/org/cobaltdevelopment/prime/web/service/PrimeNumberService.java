package uk.org.cobaltdevelopment.prime.web.service;

import uk.org.cobaltdevelopment.prime.PrimeTable;

public interface PrimeNumberService {

	/**
	 * @throws IllegalArgumentException
	 *             thrown when number of primes is less than 1
	 */
	PrimeTable createPrimeTable(int numberOfPrimes);

}
