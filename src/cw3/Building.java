package cw3;

import java.util.ArrayList;

/**
 * @author fgrami01 & jbukow01
 * 
 */ 

public class Building {
	
	public Elevator elevator;
	
	/**
	 * @param customerList
	 * @param numberOfFloors
	 * @param startingFloor
	 */

	public Building(ArrayList<Customer> customerList, int numberOfFloors,
			int startingFloor) {
		elevator = new Elevator(customerList, numberOfFloors, startingFloor);
	}
}