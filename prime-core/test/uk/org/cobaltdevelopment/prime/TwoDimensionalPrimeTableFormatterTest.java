package uk.org.cobaltdevelopment.prime;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class TwoDimensionalPrimeTableFormatterTest {

	private PrimeTableFormatter objectunderTest;
	private PrimeTable primeTableMock;

	@Before
	public void setUp() throws Exception {
		objectunderTest = new TwoDimensionalPrimeTableFormatter();
		primeTableMock = mock(PrimeTable.class);
	}

	@Test
	public void testFormatTable() {

		//@formatter:off
		String expectedTable = 
				"|      |   10 |      |\n" +
				"|    1 |  100 |    1 |\n" +
				"|    2 | 9999 | 1000 |\n";
		//@formatter:on

		when(primeTableMock.numberOfRows()).thenReturn(3);
		when(primeTableMock.numberOfCols()).thenReturn(3);

		when(primeTableMock.getCell(0, 0)).thenReturn(0);
		when(primeTableMock.getCell(0, 1)).thenReturn(10);
		when(primeTableMock.getCell(0, 2)).thenReturn(0);

		when(primeTableMock.getCell(1, 0)).thenReturn(1);
		when(primeTableMock.getCell(1, 1)).thenReturn(100);
		when(primeTableMock.getCell(1, 2)).thenReturn(1);

		when(primeTableMock.getCell(2, 0)).thenReturn(2);
		when(primeTableMock.getCell(2, 1)).thenReturn(9999);
		when(primeTableMock.getCell(2, 2)).thenReturn(1000);

		assertThat(objectunderTest.formatTable(primeTableMock), equalTo(expectedTable));

	}

	@Test
	public void testFormatSmallTable() {

		//@formatter:off
		String expectedTable = 
				"| 9999 |\n";
		//@formatter:on

		when(primeTableMock.numberOfRows()).thenReturn(1);
		when(primeTableMock.numberOfCols()).thenReturn(1);

		when(primeTableMock.getCell(0, 0)).thenReturn(9999);

		assertThat(objectunderTest.formatTable(primeTableMock), equalTo(expectedTable));

	}

}
