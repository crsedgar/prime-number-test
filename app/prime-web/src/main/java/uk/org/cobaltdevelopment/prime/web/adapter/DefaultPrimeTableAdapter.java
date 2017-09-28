package uk.org.cobaltdevelopment.prime.web.adapter;

import uk.org.cobaltdevelopment.prime.PrimeTable;
import uk.org.cobaltdevelopment.prime.web.dto.TableDto;

public class DefaultPrimeTableAdapter implements PrimeTableAdapter {

	@Override
	public TableDto convert(PrimeTable table) {
		TableDto result = new TableDto();
		return result;
	}

}
