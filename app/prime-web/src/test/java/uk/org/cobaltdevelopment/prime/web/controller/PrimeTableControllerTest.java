package uk.org.cobaltdevelopment.prime.web.controller;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import uk.org.cobaltdevelopment.prime.PrimeTable;
import uk.org.cobaltdevelopment.prime.web.adapter.PrimeTableAdapter;
import uk.org.cobaltdevelopment.prime.web.dto.TableDto;
import uk.org.cobaltdevelopment.prime.web.service.PrimeNumberService;

public class PrimeTableControllerTest {

	private PrimeNumberService serviceMock;
	private PrimeTableAdapter adapterMock;
	private PrimeTableController objectUnderTest;

	@Before
	public void setUp() throws Exception {
		serviceMock = Mockito.mock(PrimeNumberService.class);
		adapterMock = Mockito.mock(PrimeTableAdapter.class);
		objectUnderTest = new PrimeTableController(serviceMock, adapterMock);
	}

	@Test
	public void canCreateTable() {
		PrimeTable tableMock = Mockito.mock(PrimeTable.class);
		TableDto tableDtoMock = Mockito.mock(TableDto.class);

		when(serviceMock.createPrimeTable(2)).thenReturn(tableMock);
		when(adapterMock.convert(tableMock)).thenReturn(tableDtoMock);

		TableDto t = objectUnderTest.generateTable(2);

		verify(serviceMock, only()).createPrimeTable(2);
		verify(adapterMock, only()).convert(Mockito.any());

		assertThat(t, notNullValue());
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidInputRaisesException() {
		when(serviceMock.createPrimeTable(0)).thenThrow(new IllegalArgumentException());
		objectUnderTest.generateTable(0);
	}

}
