package cw3;

import java.util.ArrayList;

/**
 * @author fgrami01 & jbukow01
 * 
 */ 

public class Building {
	
	public Elevator elevator;

	public Building(ArrayList<Customer> customerList, int maxFloors,
			int startingFloor) {
		elevator = new Elevator(customerList, maxFloors, startingFloor);
	}
}