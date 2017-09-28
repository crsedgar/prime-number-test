package uk.org.cobaltdevelopment.prime;

public interface PrimeTable {

	void setFormatter(PrimeTableFormatter formatter);

	int numberOfRows();

	int numberOfCols();

	Integer getCell(int rowIdx, int colIdx);

	String formatTable();

}