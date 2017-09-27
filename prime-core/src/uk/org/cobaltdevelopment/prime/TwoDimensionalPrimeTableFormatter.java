package uk.org.cobaltdevelopment.prime;

public class TwoDimensionalPrimeTableFormatter implements PrimeTableFormatter {

	@Override
	public String formatTable(PrimeTable table) {
		StringBuilder sb = new StringBuilder();
		for (int rowidx = 0; rowidx < table.numberOfRows(); rowidx++) {
			sb.append("|");
			for (int colIdx = 0; colIdx < table.numberOfCols(); colIdx++) {
				int cell = table.getCell(rowidx, colIdx);
				if (cell > 0)
					sb.append(String.format("%5d |", cell));
				else
					sb.append(String.format("%5s |", " "));
			}
			sb.append(String.format("\n"));
		}

		return sb.toString();
	}

}
