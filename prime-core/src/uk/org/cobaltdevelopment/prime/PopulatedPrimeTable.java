package uk.org.cobaltdevelopment.prime;

public class PopulatedPrimeTable implements PrimeTable {

	private int[][] table;
	private PrimeTableFormatter formatter;

	private PopulatedPrimeTable(int[] primes) {
		final int CELL_WIDTH = primes.length + 1;
		table = new int[CELL_WIDTH][CELL_WIDTH];

		populateOuterCells(primes);
		fillTableWithMultiplication();

	}

	public static PrimeTable Make(int... primes) {
		if (primes.length == 0)
			return new EmptyPrimeTable();
		return new PopulatedPrimeTable(primes);
	}

	@Override
	public void setFormatter(PrimeTableFormatter formatter) {
		this.formatter = formatter;
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

	@Override
	public int numberOfRows() {
		return table.length;
	}

	@Override
	public int numberOfCols() {
		return table[0].length;
	}

	@Override
	public Integer getCell(int rowIdx, int colIdx) {
		return table[rowIdx][colIdx];
	}

	@Override
	public String formatTable() {
		if (formatter == null) {
			throw new IllegalStateException(
					"Formatter not set please specify formatter before requesting format behaviour");
		}
		return formatter.formatTable(this);
	}

	public static class EmptyPrimeTable implements PrimeTable {

		private PrimeTableFormatter formatter;

		@Override
		public void setFormatter(PrimeTableFormatter formatter) {
			this.formatter = formatter;
		}

		@Override
		public int numberOfRows() {
			return 0;
		}

		@Override
		public int numberOfCols() {
			return 0;
		}

		@Override
		public Integer getCell(int rowIdx, int colIdx) {
			return null;
		}

		@Override
		public String formatTable() {
			return formatter.formatTable(this);
		}

	}

}
