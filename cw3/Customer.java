/**
 * 
 */
package cw3;

/**
 * @author fgrami01 & jbukow01
 * 
 * Sets Customer variables and creates setters and getters
 * 
 */
public class Customer {

	private int startingFloor;
	private int desiredFloor;
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
		return desiredFloor;
	}

	public void setDestinationFloor(int destinationFloor) {
		this.desiredFloor = destinationFloor;
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
	 * @param desiredFloor
	 */
	public Customer(int numberOfFloors, int currentFloor, int desiredFloor) {
		customerId++;
		this.startingFloor = currentFloor;
		this.desiredFloor = desiredFloor;
		this.inElevator = false;
		this.outElevator = false;
	}
}
	
	


