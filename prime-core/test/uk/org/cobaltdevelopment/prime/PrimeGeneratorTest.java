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
	public void testOneIsNotAPrime(){
		isNotPrime(1);
	}
	
	private void isPrime(int num){
		assertThat(pg.isPrime(num), equalTo(true));
	}
	
	private void isNotPrime(int num){
		assertThat(pg.isPrime(num), equalTo(false));
	}	

}
