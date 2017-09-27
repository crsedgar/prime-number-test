package uk.org.cobaltdevelopment.prime;

public class PrimeTable {

	private int[][] table;
	
	public PrimeTable(int[] primes) {
		table = new int[primes.length+1][primes.length+1];
	}

	public int numberOfRows() {
		return table.length;
	}

	public int numberOfCols() {
		return table[0].length;
	}

}
