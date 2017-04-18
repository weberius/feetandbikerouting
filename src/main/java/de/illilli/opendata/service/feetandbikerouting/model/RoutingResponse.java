package de.illilli.opendata.service.feetandbikerouting.model;

public class RoutingResponse {

	private double distance;
	private String distanceInMeter;
	private long time;
	private String timeInMinutes;

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getDistanceInMeter() {
		return distanceInMeter;
	}

	public void setDistanceInMeter(String distanceInMeter) {
		this.distanceInMeter = distanceInMeter;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getTimeInMinutes() {
		return timeInMinutes;
	}

	public void setTimeInMinutes(String timeInMinutes) {
		this.timeInMinutes = timeInMinutes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(distance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((distanceInMeter == null) ? 0 : distanceInMeter.hashCode());
		result = prime * result + (int) (time ^ (time >>> 32));
		result = prime * result + ((timeInMinutes == null) ? 0 : timeInMinutes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoutingResponse other = (RoutingResponse) obj;
		if (Double.doubleToLongBits(distance) != Double.doubleToLongBits(other.distance))
			return false;
		if (distanceInMeter == null) {
			if (other.distanceInMeter != null)
				return false;
		} else if (!distanceInMeter.equals(other.distanceInMeter))
			return false;
		if (time != other.time)
			return false;
		if (timeInMinutes == null) {
			if (other.timeInMinutes != null)
				return false;
		} else if (!timeInMinutes.equals(other.timeInMinutes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RoutingResponse [distance=" + distance + ", distanceInMeter=" + distanceInMeter + ", time=" + time
				+ ", timeInMinutes=" + timeInMinutes + "]";
	}

}
