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
	 * Creates a customer and sets the the number of floors in the building
	 *  as well as starting and destination floors
	 * 
	 * @param numberOfFloors the number of floors in the building
	 * @param currentFloor the current floor the customer is in
	 * @param destinationFloor the desired floor of each customer
	 */
	public Customer(int numberOfFloors, int startingFloor, int destinationFloor) {
		customerId++;
		this.startingFloor = startingFloor;
		this.destinationFloor = destinationFloor;
		this.inElevator = false;
		this.outElevator = false;
	}
}