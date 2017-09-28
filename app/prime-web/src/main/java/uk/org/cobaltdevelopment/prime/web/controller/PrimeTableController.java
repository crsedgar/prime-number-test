package uk.org.cobaltdevelopment.prime.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import uk.org.cobaltdevelopment.prime.PrimeTable;
import uk.org.cobaltdevelopment.prime.web.adapter.PrimeTableAdapter;
import uk.org.cobaltdevelopment.prime.web.dto.TableDto;
import uk.org.cobaltdevelopment.prime.web.service.PrimeNumberService;

@Controller
public class PrimeTableController {

	private PrimeNumberService service;
	private PrimeTableAdapter adapter;

	@Autowired
	public PrimeTableController(PrimeNumberService service, PrimeTableAdapter adapter) {
		super();
		this.service = service;
		this.adapter = adapter;
	}

	public TableDto generateTable(int numberOfPrimes) {
		PrimeTable primeTable = service.createPrimeTable(numberOfPrimes);
		TableDto tableDto = adapter.convert(primeTable);
		return tableDto;
	}

}
