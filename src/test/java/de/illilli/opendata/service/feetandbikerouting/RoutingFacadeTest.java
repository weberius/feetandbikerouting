package de.illilli.opendata.service.feetandbikerouting;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import de.illilli.opendata.service.Facade;

public class RoutingFacadeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws JsonProcessingException {
		String vehicle = "foot";
		String fromTo = "50.940214,6.953710,50.940356,6.961413";
		Facade facade = new RoutingFacade(vehicle, fromTo);
		System.out.println(facade.getJson());
	}

}
