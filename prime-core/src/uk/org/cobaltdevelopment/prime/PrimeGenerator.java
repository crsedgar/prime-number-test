package uk.org.cobaltdevelopment.prime;

public class PrimeGenerator {

	public int generatePrime(int numToGenerate) {
		return 0;
	}

	public boolean isPrime(int number) {
		boolean isPrime = true;

		if (number < 1) {
			throw new IllegalArgumentException("Illegal argument only natural numbers are expected");
		}

		if (number > 2 && (number % 2 == 0)) {
			isPrime = false;
		}

		if (number < 2) {
			isPrime = false;
		}

		return isPrime;
	}

}
