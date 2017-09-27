package uk.org.cobaltdevelopment.prime.web.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import uk.org.cobaltdevelopment.prime.PrimeGenerator;
import uk.org.cobaltdevelopment.prime.PrimeTable;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DefaultPrimeNumberService.class)
public class PrimeNumberServiceTest {

	PrimeGenerator primeGenerator;
	PrimeTable tableMock;

	@Before
	public void setUp() throws Exception {
		primeGenerator = mock(PrimeGenerator.class);
		tableMock = mock(PrimeTable.class);
	}

	@Test
	public void canCreateTable() throws Exception {
		int[] generatedPrimes = new int[] { 2, 3 };

		PrimeNumberService objectUnderTest = PowerMockito.spy(new DefaultPrimeNumberService(primeGenerator));

		when(primeGenerator.generatePrimes(2)).thenReturn(generatedPrimes);
		PowerMockito.when(objectUnderTest, "constructTable", generatedPrimes).thenReturn(tableMock);

		PrimeTable table = objectUnderTest.createPrimeTable(2);

		assertThat(table, equalTo(tableMock));
		verify(primeGenerator, times(1)).generatePrimes(2);
		PowerMockito.verifyPrivate(objectUnderTest).invoke("constructTable", generatedPrimes);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidArgument() {
		PrimeNumberService objectUnderTest = new DefaultPrimeNumberService(primeGenerator);
		objectUnderTest.createPrimeTable(0);
	}

}
