package uk.org.cobaltdevelopment.prime;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class PrimeTableTest {

	@Test
	public void canCreateTable() {
		PopulatedPrimeTable.Make(2);
	}

	@Test
	public void canGenerateSmallestTable() {
		PrimeTable t = PopulatedPrimeTable.Make(2);
		assertThat(t.numberOfRows(), equalTo(2));
		assertThat(t.numberOfCols(), equalTo(2));

		assertThat(t.getCell(0, 0), equalTo(0));
		assertThat(t.getCell(0, 1), equalTo(2));
		assertThat(t.getCell(1, 0), equalTo(2));
		assertThat(t.getCell(1, 1), equalTo(4));
	}

	@Test
	public void canGenerateTableOfTwoPrimes() {
		PrimeTable primeTable = PopulatedPrimeTable.Make(2, 3);

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
		PrimeTable primeTable = PopulatedPrimeTable.Make();
		TwoDimensionalPrimeTableFormatter formatterMock = mock(TwoDimensionalPrimeTableFormatter.class);

		//@formatter:off
		String expectedTable = 
				"|      |    2 |\n" +
				"|    2 |    4 |\n";
		//@formatter:on

		when(formatterMock.formatTable(primeTable)).thenReturn(expectedTable);

		primeTable.setFormatter(formatterMock);
		String table = primeTable.formatTable();

		assertThat(table, equalTo(expectedTable));

		verify(formatterMock, times(1)).formatTable(primeTable);

	}

	@Test(expected = IllegalStateException.class)
	public void formatTableWithoutFormatter() {
		PrimeTable primeTable = PopulatedPrimeTable.Make(2, 3, 5);
		primeTable.formatTable();
	}

	@Test
	public void canCreateEmptyTable() {
		PrimeTable table = PopulatedPrimeTable.Make();
		assertThat(table.numberOfCols(), equalTo(0));
		assertThat(table.numberOfRows(), equalTo(0));
		assertThat(table.getCell(0, 0), nullValue());
	}

}
