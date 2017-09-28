package uk.org.cobaltdevelopment.prime.web.controller;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import uk.org.cobaltdevelopment.prime.PrimeTable;
import uk.org.cobaltdevelopment.prime.web.dto.TableDto;
import uk.org.cobaltdevelopment.prime.web.service.PrimeNumberService;

public class PrimeTableControllerTest {

	private PrimeNumberService serviceMock;

	@Before
	public void setUp() throws Exception {
		serviceMock = Mockito.mock(PrimeNumberService.class);
	}

	@Test
	public void canCreateController() {
		new PrimeTableController(serviceMock);
	}

	@Ignore
	@Test
	public void canCreateTable() {
		PrimeTable value = Mockito.mock(PrimeTable.class);
		Mockito.when(serviceMock.createPrimeTable(2)).thenReturn(value);

		PrimeTableController controller = new PrimeTableController(serviceMock);
		TableDto t = controller.generateTable(2);

		Mockito.verify(serviceMock, Mockito.only()).createPrimeTable(2);
		assertThat(t, Matchers.notNullValue());
	}

}
