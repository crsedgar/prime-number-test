package uk.org.cobaltdevelopment.prime.web.adapter;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import uk.org.cobaltdevelopment.prime.PrimeTable;
import uk.org.cobaltdevelopment.prime.web.dto.RowDto;
import uk.org.cobaltdevelopment.prime.web.dto.TableDto;

public class DefaultPrimeTableAdapterTest {

	private PrimeTableAdapter adapter;

	@Before
	public void setup() {
		adapter = new DefaultPrimeTableAdapter();
	}

	@Test
	public void canAdaptPrimeTableToDto() {
		PrimeTable primeTableMock = Mockito.mock(PrimeTable.class);
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

		TableDto result = adapter.convert(primeTableMock);

		assertThat(result, Matchers.notNullValue());

		List<RowDto> rows = result.getRows();
		assertThat(rows, Matchers.hasSize(3));
		assertThat(rows.get(0).getCols().get(0), equalTo(0));
	}
}
