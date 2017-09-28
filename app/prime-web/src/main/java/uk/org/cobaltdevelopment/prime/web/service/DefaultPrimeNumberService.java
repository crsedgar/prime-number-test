package uk.org.cobaltdevelopment.prime.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.org.cobaltdevelopment.prime.PopulatedPrimeTable;
import uk.org.cobaltdevelopment.prime.PrimeGenerator;
import uk.org.cobaltdevelopment.prime.PrimeTable;

@Service
public class DefaultPrimeNumberService implements PrimeNumberService {

	private PrimeGenerator primeGenerator;

	@Autowired
	public DefaultPrimeNumberService(PrimeGenerator primeGenerator) {
		super();
		this.primeGenerator = primeGenerator;
	}

	@Override
	public PrimeTable createPrimeTable(int numberOfPrimes) {
		if (numberOfPrimes < 1) {
			throw new IllegalArgumentException("number of primes must be greater than zero.");
		}
		int[] generatedPrimes = primeGenerator.generatePrimes(numberOfPrimes);
		PrimeTable table = constructTable(generatedPrimes);
		return table;
	}

	private PrimeTable constructTable(int[] generatedPrimes) {
		return PopulatedPrimeTable.Make(generatedPrimes);
	}

}
