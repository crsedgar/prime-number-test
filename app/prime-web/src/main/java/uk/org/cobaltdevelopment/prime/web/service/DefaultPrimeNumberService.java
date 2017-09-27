package uk.org.cobaltdevelopment.prime.web.service;

import uk.org.cobaltdevelopment.prime.PrimeGenerator;
import uk.org.cobaltdevelopment.prime.PrimeTable;

public class DefaultPrimeNumberService implements PrimeNumberService {

	private PrimeGenerator primeGenerator;

	public DefaultPrimeNumberService(PrimeGenerator primeGenerator) {
		super();
		this.primeGenerator = primeGenerator;
	}

	@Override
	public PrimeTable createPrimeTable(int numberOfPrimes) {
		int[] generatedPrimes = primeGenerator.generatePrimes(numberOfPrimes);
		PrimeTable table = constructTable(generatedPrimes);
		return table;
	}

	private PrimeTable constructTable(int[] generatedPrimes) {
		return new PrimeTable(generatedPrimes);
	}

}
