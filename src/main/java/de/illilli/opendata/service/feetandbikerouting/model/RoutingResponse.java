package de.illilli.opendata.service.feetandbikerouting.model;

public class RoutingResponse {

	private double distance;
	private String distanceFormatted;
	private long time;
	private String timeFormatted;

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getDistanceFormatted() {
		return distanceFormatted;
	}

	public void setDistanceFormatted(String distanceFormatted) {
		this.distanceFormatted = distanceFormatted;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getTimeFormatted() {
		return timeFormatted;
	}

	public void setTimeFormatted(String timeFormatted) {
		this.timeFormatted = timeFormatted;
	}

}
