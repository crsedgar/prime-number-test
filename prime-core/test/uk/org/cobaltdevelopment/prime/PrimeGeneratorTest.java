package uk.org.cobaltdevelopment.prime;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class PrimeGeneratorTest {

	private PrimeGenerator pg;

	@Before
	public void setUp() {
		pg = new PrimeGenerator();
	}

	@Ignore
	@Test
	public void canGeneratorFirstPrime() {
		assertThat(pg.generatePrime(1), equalTo(new int[] { 2 }));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNonNaturalNumbersZero() {
		pg.isPrime(0);
	}

	@Test
	public void testTheOnlyEvenPrime() {
		assertThat(pg.isPrime(2), equalTo(true));
		assertThat(pg.isPrime(4), equalTo(false));
	}
	
	@Test
	public void testOneIsNotAPrime(){
		assertThat(pg.isPrime(1), equalTo(false));
	}

}
