package uk.org.cobaltdevelopment.prime;

public class PrimeGenerator {

	public int[] generatePrimes(int numToGenerate) {
		int[] result = new int[numToGenerate];
		int primesFound = 0;
		int currentNum = 2;

		while (primesFound < numToGenerate) {
			if (isPrime(currentNum)) {
				result[primesFound] = currentNum;
				primesFound++;
			}
			currentNum++;
		}

		return result;
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

		if (greaterThanFiveAndEndsInFive(number)) {
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

	private boolean greaterThanFiveAndEndsInFive(int number) {
		return number > 5 && number % 10 == 5;
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
