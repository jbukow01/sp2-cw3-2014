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
	private int destinationFloor;
	private static int CustomerId;
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
	
	public void setDestinationFloor(int destinationFloor) {
		this.destinationFloor = destinationFloor;
	}
	
	public static int getCustomerId() {
		return CustomerId;
	}
	
	public static void setCustomerId(int customerId) {
		CustomerId = customerId;
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
	 * @author fgrami01 & jbukow01
	 * 
	 * Creates a customer and sets starting and destination floors
	 * @param noOfFloors
	 * @param currentFloor
	 * @param destinationFloor
	 */
	public Customer(int noOfFloors, int currentFloor, int destinationFloor)
	{
		CustomerId++;
		this.startingFloor = currentFloor;
		this.destinationFloor = destinationFloor;
		this.inElevator = false;
		outElevator = false;
	}

	
	

}
