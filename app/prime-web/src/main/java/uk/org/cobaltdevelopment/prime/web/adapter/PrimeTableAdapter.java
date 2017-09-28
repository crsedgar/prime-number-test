package uk.org.cobaltdevelopment.prime.web.adapter;

import uk.org.cobaltdevelopment.prime.PrimeTable;
import uk.org.cobaltdevelopment.prime.web.dto.TableDto;

public interface PrimeTableAdapter {

	TableDto convert(PrimeTable table);

}