package de.illilli.opendata.service.feetandbikerouting.model;

public class RoutingResponse {

	private double distance;
	private long time;

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	/**
	 *
	 * @return time in ms
	 */
	public long getTime() {
		return time;
	}

	public void setTime(long timeInMs) {
		this.time = timeInMs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(distance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (time ^ (time >>> 32));
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
		if (time != other.time)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RoutingResponse [distance=" + distance + ", timeInMs=" + time + "]";
	}

}
