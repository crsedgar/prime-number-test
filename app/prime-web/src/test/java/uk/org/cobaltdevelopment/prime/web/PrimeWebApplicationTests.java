package uk.org.cobaltdevelopment.prime.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import uk.org.cobaltdevelopment.prime.web.controller.Controllers;

@ContextConfiguration(classes = { Controllers.class })
@RunWith(SpringRunner.class)
@SpringBootTest
public class PrimeWebApplicationTests {

	@Test
	public void contextLoads() {
	}

}
