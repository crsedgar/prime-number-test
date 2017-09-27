package uk.org.cobaltdevelopment.prime.web.service;

import org.junit.Before;
import org.junit.Test;

public class PrimeNumberServiceTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void canCreateService() {
		PrimeNumberService service = new DefaultPrimeNumberService();
	}

}
