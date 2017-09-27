package uk.org.cobaltdevelopment.prime.web.controller;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import uk.org.cobaltdevelopment.prime.web.dto.TableDto;

public class PrimeTableControllerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void canCreateController() {
		new PrimeTableController();
	}

	@Test
	public void canCreateTable() {
		PrimeTableController controller = new PrimeTableController();
		TableDto t = controller.generateTable(2);
		assertThat(t, Matchers.notNullValue());
	}

}
