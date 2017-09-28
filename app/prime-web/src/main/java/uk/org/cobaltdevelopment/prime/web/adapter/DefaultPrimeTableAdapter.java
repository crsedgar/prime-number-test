package uk.org.cobaltdevelopment.prime.web.adapter;

import uk.org.cobaltdevelopment.prime.PrimeTable;
import uk.org.cobaltdevelopment.prime.web.dto.RowDto;
import uk.org.cobaltdevelopment.prime.web.dto.TableDto;
import uk.org.cobaltdevelopment.prime.web.dto.TableDto.TableDtoBuilder;

public class DefaultPrimeTableAdapter implements PrimeTableAdapter {

	@Override
	public TableDto convert(PrimeTable table) {
		TableDtoBuilder builder = TableDtoBuilder.create();
		for (int i = 0; i < table.numberOfRows(); i++) {
			builder.row(new RowDto());
		}

		return builder.build();
	}

}
