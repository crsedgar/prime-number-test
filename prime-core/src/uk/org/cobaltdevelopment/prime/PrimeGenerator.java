package uk.org.cobaltdevelopment.prime;

public class PrimeGenerator {

	public int generatePrime(int numToGenerate) {
		return 0;
	}

	public boolean isPrime(int number) {
		boolean isPrime = true;

		if (!naturalNumber(number)) {
			throw new NotNaturalNumberException();
		}

		if (evenNumberGreaterThanTwo(number)) {
			isPrime = false;
		}

		if (lessThanTwo(number)) {
			isPrime = false;
		}

		return isPrime;
	}

	private boolean lessThanTwo(int number) {
		return number < 2;
	}

	private boolean naturalNumber(int number) {
		return number > 0;
	}

	private boolean evenNumberGreaterThanTwo(int number) {
		return number > 2 && (number % 2 == 0);
	}

}

@SuppressWarnings("serial")
class NotNaturalNumberException extends RuntimeException{
	
}
