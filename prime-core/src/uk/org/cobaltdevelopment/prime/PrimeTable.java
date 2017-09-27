package uk.org.cobaltdevelopment.prime;

public class PrimeTable {

	private int[][] table;

	public PrimeTable(int[] primes) {
		final int CELL_WIDTH = primes.length + 1;
		table = new int[CELL_WIDTH][CELL_WIDTH];

		populateOuterCells(primes);
		fillTableWithMultiplication();

	}

	private void fillTableWithMultiplication() {
		for (int rowIdx = 1; rowIdx < table.length; rowIdx++) {
			for (int colIdx = 1; colIdx < table.length; colIdx++) {
				int rowPrime = table[rowIdx][0];
				int colPrime = table[0][colIdx];
				table[rowIdx][colIdx] = rowPrime * colPrime;
			}
		}
	}

	private void populateOuterCells(int[] primes) {
		int primeCount = 1;

		for (int i = 0; i < primes.length; i++) {
			table[0][primeCount] = primes[i];
			table[primeCount][0] = primes[i];
			primeCount++;
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

	public String formatTable() {
		return null;
	}

}
