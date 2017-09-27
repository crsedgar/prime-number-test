package uk.org.cobaltdevelopment.prime;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PrimeTableTest {

	@Test
	public void canCreateTable() {
		PrimeTable t = new PrimeTable(new int[] { 2 });
	}

	@Test
	public void canGenerateSmallestTable() {
		PrimeTable t = new PrimeTable(new int[] { 2 });
		assertThat(t.numberOfRows(), equalTo(2));
	}
}
