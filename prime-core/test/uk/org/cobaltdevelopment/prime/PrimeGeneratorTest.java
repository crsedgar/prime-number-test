package uk.org.cobaltdevelopment.prime;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PrimeGeneratorTest {

	private PrimeGenerator pg;

	@Before
	public void setUp() {
		pg = new PrimeGenerator();
	}

	@Test
	public void canGeneratorFirstPrime() {
		assertThat(pg.generatePrime(1), equalTo(new int[] { 2 }));
	}

	@Test
	public void canGeneratorFirstTwoPrimes() {
		assertThat(pg.generatePrime(2), equalTo(new int[] { 2, 3 }));
	}

	@Test(expected = NotNaturalNumberException.class)
	public void testNonNaturalNumbersZero() {
		pg.isPrime(0);
	}

	@Test
	public void testTheOnlyEvenPrime() {
		isPrime(2);
		isNotPrime(4);
	}

	@Test
	public void testOneIsNotAPrime() {
		isNotPrime(1);
	}

	@Test
	public void testSecondPrime() {
		isPrime(3);
	}

	@Test
	public void testLargePrime() {
		isPrime(997);
	}

	@Test
	public void testPrimeLargerThanFiveEndingInFive() {
		isNotPrime(505);
		isPrime(5);
	}

	@Test
	public void testLargeNonPrime() {
		isNotPrime(999);
	}

	private void isPrime(int num) {
		assertThat(pg.isPrime(num), equalTo(true));
	}

	private void isNotPrime(int num) {
		assertThat(pg.isPrime(num), equalTo(false));
	}

}
