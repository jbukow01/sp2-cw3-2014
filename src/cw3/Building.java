package cw3;

import java.util.ArrayList;

/**
 * @author fgrami01 & jbukow01
 * 
 */ 

public class Building {
	
	public Elevator elevator;
	
	/**
	 * Creates a building
	 * 
	 * @param customerList list of customers to be added to the elevator
	 * @param numberOfFloors random maximum floor
	 * @param startingFloor random floor in which customer starts journey
	 */

	public Building(ArrayList<Customer> customerList, int numberOfFloors, int startingFloor) {
		elevator = new Elevator(customerList, numberOfFloors, startingFloor);
	}
}