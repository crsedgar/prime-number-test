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
		assertGenerate(1, new int[] { 2 });
	}

	@Test
	public void canGeneratorFirstTwoPrimes() {
		assertGenerate(2, new int[] { 2, 3 });
	}

	@Test
	public void canGeneratorFirstTenPrimes() {
		assertGenerate(10, new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 });
	}

	@Test(expected = PrimeGenerator.NotNaturalNumberException.class)
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

	private void assertGenerate(int numberToGenerate, int[] expectedResult) {
		assertThat(pg.generatePrimes(numberToGenerate), equalTo(expectedResult));
	}

	private void isPrime(int num) {
		assertThat(pg.isPrime(num), equalTo(true));
	}

	private void isNotPrime(int num) {
		assertThat(pg.isPrime(num), equalTo(false));
	}

}
