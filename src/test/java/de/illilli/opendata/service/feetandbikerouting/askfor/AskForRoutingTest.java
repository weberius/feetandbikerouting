package de.illilli.opendata.service.feetandbikerouting.askfor;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.graphhopper.PathWrapper;
import com.graphhopper.util.Instruction;
import com.graphhopper.util.InstructionList;
import com.graphhopper.util.PointList;

import de.illilli.opendata.service.AskFor;

public class AskForRoutingTest {

	private static final Logger logger = Logger.getLogger(AskForRoutingTest.class);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		String vehicle = "foot";
		AskFor<PathWrapper> askFor = new AskForRouting(vehicle, 50.940214, 6.953710, 50.940356, 6.961413);
		PathWrapper path = askFor.getData();

		// points, distance in meters and time in millis of the full path
		PointList pointList = path.getPoints();
		logger.info(pointList.toString());
		double distance = path.getDistance();
		logger.info("distance: " + distance);
		long timeInMs = path.getTime();
		logger.info("timeInMs: " + timeInMs);

		InstructionList instructionList = path.getInstructions();
		// iterate over every turn instruction
		for (Instruction instruction : instructionList) {
			logger.info(instruction.getDistance());
		}

	}

}
