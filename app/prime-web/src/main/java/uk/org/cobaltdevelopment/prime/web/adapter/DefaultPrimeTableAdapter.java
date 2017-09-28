package uk.org.cobaltdevelopment.prime.web.adapter;

import uk.org.cobaltdevelopment.prime.PrimeTable;
import uk.org.cobaltdevelopment.prime.web.dto.RowDto.RowDtoBuilder;
import uk.org.cobaltdevelopment.prime.web.dto.TableDto;
import uk.org.cobaltdevelopment.prime.web.dto.TableDto.TableDtoBuilder;

public class DefaultPrimeTableAdapter implements PrimeTableAdapter {

	@Override
	public TableDto convert(PrimeTable table) {
		TableDtoBuilder tableBuilder = TableDtoBuilder.create();
		for (int i = 0; i < table.numberOfRows(); i++) {
			RowDtoBuilder rowBuilder = RowDtoBuilder.create();
			for (int j = 0; j < table.numberOfCols(); j++) {
				rowBuilder.colValue(table.getCell(i, j));
			}
			tableBuilder.row(rowBuilder.build());
		}

		return tableBuilder.build();
	}

}
