package uk.org.cobaltdevelopment.prime;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PrimeTableTest {

	@Test
	public void canCreateTable() {
		new PrimeTable(new int[] { 2 });
	}

	@Test
	public void canGenerateSmallestTable() {
		PrimeTable t = new PrimeTable(new int[] { 2 });
		assertThat(t.numberOfRows(), equalTo(2));
		assertThat(t.numberOfCols(), equalTo(2));

		assertThat(t.getCell(0, 0), equalTo(0));
		assertThat(t.getCell(0, 1), equalTo(2));
		assertThat(t.getCell(1, 0), equalTo(2));
		assertThat(t.getCell(1, 1), equalTo(4));
	}

	@Test
	public void canGenerateTableOfTwoPrimes() {
		PrimeTable primeTable = new PrimeTable(new int[] { 2, 3 });

		assertThat(primeTable.numberOfRows(), equalTo(3));
		assertThat(primeTable.numberOfCols(), equalTo(3));

		assertThat(primeTable.getCell(0, 0), equalTo(0));
		assertThat(primeTable.getCell(0, 1), equalTo(2));
		assertThat(primeTable.getCell(0, 2), equalTo(3));

		assertThat(primeTable.getCell(1, 0), equalTo(2));
		assertThat(primeTable.getCell(2, 0), equalTo(3));

		assertThat(primeTable.getCell(1, 1), equalTo(4));
		assertThat(primeTable.getCell(1, 2), equalTo(6));

		assertThat(primeTable.getCell(2, 1), equalTo(6));
		assertThat(primeTable.getCell(2, 2), equalTo(9));
	}

	@Test
	public void canFormatTable() {
		PrimeTable primeTable = new PrimeTable(new int[] { 2, 3, 5 });
		String table = primeTable.formatTable();
		//@formatter:off
		String expectedTable = 
				"|    |   2|   3|\n" +
				"|   2|   4|   6|\n" +
				"|   3|   6|   9|\n";
		//@formatter:on

		assertThat(table, equalTo(expectedTable));
	}
}
