package uk.org.cobaltdevelopment.prime;

public class PrimeGenerator {

	public int generatePrime(int numToGenerate) {
		boolean found = false;
		int currentNum = 2;
		while (!found) {
			if (isPrime(currentNum)) {
				found = true;
			} else {
				currentNum++;
			}
		}

		return currentNum;
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

		if (number > 5 && number % 10 == 5) {
			isPrime = false;
		}

		for (int i = number - 1; i > 1; --i) {
			if (number % i == 0) {
				isPrime = false;
				break;
			}
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
class NotNaturalNumberException extends RuntimeException {

}
