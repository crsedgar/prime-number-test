package uk.org.cobaltdevelopment.prime.web.dto;

import java.util.ArrayList;
import java.util.List;

public class TableDto {

	private List<RowDto> rows;

	public TableDto(List<RowDto> rows) {
		super();
		this.rows = rows;
	}

	public List<RowDto> getRows() {
		return rows;
	}

	public static class TableDtoBuilder {

		private List<RowDto> rows;

		private TableDtoBuilder() {
			rows = new ArrayList<>();
		}

		public static TableDtoBuilder create() {
			return new TableDtoBuilder();
		}

		public TableDtoBuilder row(RowDto value) {
			rows.add(value);
			return this;
		}

		public TableDtoBuilder rows(List<RowDto> value) {
			rows.addAll(value);
			return this;
		}

		public TableDto build() {
			TableDto content = new TableDto(rows);
			return content;
		}
	}
}
