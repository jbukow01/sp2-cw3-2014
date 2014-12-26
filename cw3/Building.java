package cw3;

import java.util.ArrayList;

/**
 * @author fgrami01 & jbukow01
 *
 */

public class Building {

	public Building(ArrayList<Customer> customerList, int maxFloors,
			int groundFloor) {
		Elevator elevator = new Elevator(customerList, maxFloors, groundFloor);
	}
}