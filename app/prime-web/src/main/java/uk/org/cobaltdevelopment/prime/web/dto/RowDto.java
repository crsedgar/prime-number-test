package uk.org.cobaltdevelopment.prime.web.dto;

import java.util.ArrayList;
import java.util.List;

public class RowDto {

	private List<Integer> cols;

	public RowDto(List<Integer> cols) {
		super();
		this.cols = cols;
	}

	public List<Integer> getCols() {
		return cols;
	}

	public static class RowDtoBuilder {
		private List<Integer> cols;

		private RowDtoBuilder() {
			cols = new ArrayList<>();
		}

		public static RowDtoBuilder create() {
			return new RowDtoBuilder();
		}

		public RowDtoBuilder colValue(int value) {
			cols.add(value);
			return this;
		}

		public RowDto build() {
			return new RowDto(cols);
		}
	}

}
