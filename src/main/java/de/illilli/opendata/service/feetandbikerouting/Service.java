package de.illilli.opendata.service.feetandbikerouting;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import de.illilli.opendata.service.Config;
import de.illilli.opendata.service.Facade;

@Path("/")
public class Service {

	private final static Logger logger = Logger.getLogger(Service.class);
	public static final String ENCODING = Config.getProperty("encoding");

	private long date = 0;

	@Context
	private HttpServletRequest request;
	@Context
	private HttpServletResponse response;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/ping")
	public String getPing() throws MalformedURLException, IOException {

		request.setCharacterEncoding(ENCODING);
		response.setCharacterEncoding(ENCODING);

		return "{alive}";
	}

	/**
	 * <p>
	 * Beispiel: <a href=
	 * "http://localhost:8080/feetandbikerouting/service/foot?fromTo=50.940214,6.953710,50.940356,6.961413">
	 * /feetandbikerouting/service/foot?fromTo=50.940214,6.953710,50.940356,6.
	 * 961413</a>
	 * </p>
	 * 
	 * @param vehicle
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/{vehicle}")
	public String getVehicle(@PathParam("vehicle") String vehicle) throws MalformedURLException, IOException {

		request.setCharacterEncoding(ENCODING);
		response.setCharacterEncoding(ENCODING);

		String fromTo = request.getParameter("fromTo");

		Facade facade = null;
		if ("foot".equals(vehicle)) {
			logger.info("request /feetandbikerouting/service/foot?fromTo=" + fromTo);
			facade = new RoutingFacade(vehicle, fromTo);
		} else {
			logger.error("request /feetandbikerouting/service/" + vehicle + "?fromTo=" + fromTo + " not available");
			facade = new ErrorFacade("error.service.vehicle");
		}

		return facade.getJson();
	}

}
