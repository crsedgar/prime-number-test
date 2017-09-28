package uk.org.cobaltdevelopment.prime.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import uk.org.cobaltdevelopment.prime.PrimeTable;
import uk.org.cobaltdevelopment.prime.web.dto.TableDto;
import uk.org.cobaltdevelopment.prime.web.service.PrimeNumberService;

@Controller
public class PrimeTableController {

	private PrimeNumberService service;

	@Autowired
	public PrimeTableController(PrimeNumberService service) {
		super();
		this.service = service;
	}




	public TableDto generateTable(int numberOfPrimes) {
		PrimeTable primeTable = service.createPrimeTable(numberOfPrimes);
		return null;
	}

}
