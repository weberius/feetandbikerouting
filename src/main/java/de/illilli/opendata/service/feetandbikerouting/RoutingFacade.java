package de.illilli.opendata.service.feetandbikerouting;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.graphhopper.PathWrapper;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.LatLngLatLngFromString;
import de.illilli.opendata.service.feetandbikerouting.askfor.AskForRouting;
import de.illilli.opendata.service.feetandbikerouting.model.RoutingResponse;

public class RoutingFacade implements Facade {

	private RoutingResponse data = new RoutingResponse();

	public RoutingFacade(String vehicle, String fromTo) {

		LatLngLatLngFromString lfs = new LatLngLatLngFromString(fromTo);
		double latFrom = lfs.getLatFrom();
		double lonFrom = lfs.getLngFrom();
		double latTo = lfs.getLatTo();
		double lonTo = lfs.getLngTo();

		AskFor<PathWrapper> askFor = new AskForRouting(vehicle, latFrom, lonFrom, latTo, lonTo);
		PathWrapper path = askFor.getData();
		// set Data
		data.setDistance(path.getDistance());
		int meter = (int) Math.round(path.getDistance());
		data.setDistanceInMeter(meter + "");
		data.setTime(path.getTime());
		// add 1 Minute for every request.
		int minutes = Math.round(path.getTime() / 60000) + 1;
		data.setTimeInMinutes(minutes + "");
	}

	@Override
	public String getJson() throws JsonProcessingException {
		return new Gson().toJson(data);
	}

}
