package de.illilli.opendata.service.feetandbikerouting.askfor;

import java.util.Locale;

import org.apache.log4j.Logger;

import com.graphhopper.GHRequest;
import com.graphhopper.GHResponse;
import com.graphhopper.GraphHopper;
import com.graphhopper.PathWrapper;
import com.graphhopper.reader.osm.GraphHopperOSM;
import com.graphhopper.routing.util.EncodingManager;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.Config;

/**
 * Example for Routing with graphhopper <a href=
 * "https://github.com/graphhopper/graphhopper/blob/0.8/docs/core/routing.md">
 * Routing via Java API</a>
 */
public class AskForRouting implements AskFor<PathWrapper> {

	private String graphFolder = Config.getProperty("graphhopper.graphFolder");
	private String osmFile = Config.getProperty("graphhopper.osmFile");
	private static final String ENCODING = Config.getProperty("graphhopper.encoding");
	private static final String WEIGHTING = Config.getProperty("graphhopper.weighting");

	private static final Logger logger = Logger.getLogger(AskForRouting.class);

	private PathWrapper path;

	public AskForRouting(String vehicle, double latFrom, double lonFrom, double latTo, double lonTo) {

		// create one GraphHopper instance
		GraphHopper hopper = new GraphHopperOSM().forServer();
		hopper.setDataReaderFile(osmFile);
		// where to store graphhopper files?
		hopper.setGraphHopperLocation(graphFolder);
		hopper.setEncodingManager(new EncodingManager(ENCODING));
		// now this can take minutes if it imports or a few seconds for loading
		// of course this is dependent on the area you import
		hopper.importOrLoad();
		// simple configuration of the request object, see the
		// GraphHopperServlet classs for more possibilities.
		GHRequest req = new GHRequest(latFrom, lonFrom, latTo, lonTo).setWeighting(WEIGHTING).setVehicle(vehicle)
				.setLocale(Locale.GERMAN);
		GHResponse rsp = hopper.route(req);
		// first check for errors
		if (rsp.hasErrors()) {
			// handle them!
			// rsp.getErrors()
			return;
		}
		// use the best path, see the GHResponse class for more possibilities.
		this.path = rsp.getBest();
	}

	@Override
	public PathWrapper getData() {
		return path;
	}

}
