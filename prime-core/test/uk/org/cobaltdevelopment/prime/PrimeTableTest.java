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
		assertThat(t.numberOfCols(), equalTo(2));
		
		assertThat(t.getCell(0,0), equalTo(0));
		assertThat(t.getCell(0,1), equalTo(2));
		assertThat(t.getCell(1,0), equalTo(2));
		assertThat(t.getCell(1,1), equalTo(4));
	}
}
