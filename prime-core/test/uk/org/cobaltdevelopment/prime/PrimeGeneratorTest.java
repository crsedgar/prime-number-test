package uk.org.cobaltdevelopment.prime;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PrimeGeneratorTest {

	@Test
	public void canGeneratorFirstPrime() {
		PrimeGenerator pg = new PrimeGenerator();
		assertThat(pg.generatePrime(1), equalTo(new int[] { 2 }));
	}

}
