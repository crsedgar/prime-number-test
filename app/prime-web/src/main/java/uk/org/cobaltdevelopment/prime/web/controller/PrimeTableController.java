package uk.org.cobaltdevelopment.prime.web.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import uk.org.cobaltdevelopment.prime.PrimeTable;
import uk.org.cobaltdevelopment.prime.web.adapter.PrimeTableAdapter;
import uk.org.cobaltdevelopment.prime.web.dto.TableDto;
import uk.org.cobaltdevelopment.prime.web.service.PrimeNumberService;

@Controller("/")
public class PrimeTableController {

	private PrimeNumberService service;
	private PrimeTableAdapter adapter;

	@Autowired
	public PrimeTableController(PrimeNumberService service, PrimeTableAdapter adapter) {
		super();
		this.service = service;
		this.adapter = adapter;
	}

	@RequestMapping(path = "api/table/{numberOfPrimes}", method = { GET })
	public @ResponseBody TableDto generateTable(@PathVariable("numberOfPrimes") int numberOfPrimes) {
		PrimeTable primeTable = service.createPrimeTable(numberOfPrimes);
		TableDto tableDto = adapter.convert(primeTable);
		return tableDto;
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Number of primes must be greater than zero")
	@ExceptionHandler(IllegalArgumentException.class)
	public void errorHandler() {
		// do nothing
	}

}
