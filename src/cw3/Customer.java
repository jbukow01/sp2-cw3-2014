package cw3;

/**
 * @author fgrami01 & jbukow01
 * 
 */

public class Customer {

	private int startingFloor;
	private int destinationFloor;
	private static int customerId = 100;
	private boolean inElevator;
	private boolean outElevator;

	public int getStartingFloor() {
		return startingFloor;
	}

	public void setStartingFloor(int startingFloor) {
		this.startingFloor = startingFloor;
	}

	public int getDestinationFloor() {
		return destinationFloor;
	}

	public void setDestinationFloor(int desiredFloor) {
		this.destinationFloor = desiredFloor;
	}

	public static int getCustomerId() {
		return customerId;
	}

	public boolean isInElevator() {
		return inElevator;
	}

	public void setInElevator(boolean inElevator) {
		this.inElevator = inElevator;
	}

	public boolean isOutElevator() {
		return outElevator;
	}

	public void setOutElevator(boolean outElevator) {
		this.outElevator = outElevator;
	}

	/**
	 * @param numberOfFloors
	 * @param currentFloor
	 * @param destinationFloor
	 */
	public Customer(int numberOfFloors, int startingFloor, int destinationFloor) {
		customerId++;
		this.startingFloor = startingFloor;
		this.destinationFloor = destinationFloor;
		this.inElevator = false;
		this.outElevator = false;
	}
}