package uk.org.cobaltdevelopment.prime;

public class PrimeTable {

	private int[][] table;

	public PrimeTable(int[] primes) {
		table = new int[primes.length + 1][primes.length + 1];

		int primeCount = 1;
		// populate outer cells
		for (int i = 0; i < primes.length; i++) {
			table[0][primeCount] = primes[i];
			table[primeCount][0] = primes[i];
			primeCount++;
		}

		// fill in multiplication
		for (int i = 1; i < table.length; i++) {
			for (int j = 1; j < table.length; j++) {
				int rowPrime = table[i][0];
				int colPrime = table[0][j];
				table[i][j] = rowPrime * colPrime;
			}
		}

	}

	public int numberOfRows() {
		return table.length;
	}

	public int numberOfCols() {
		return table[0].length;
	}

	public int getCell(int rowIdx, int colIdx) {
		return table[rowIdx][colIdx];
	}

}
