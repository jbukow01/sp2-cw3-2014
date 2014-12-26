/**
 * 
 */
package cw3;

import java.util.ArrayList;

/**
 * @author fgrami01 & jbukow01
 *
 */
public class Elevator {

	private final int NUMBER_OF_FLOORS;
	private ArrayList<Customer> customerBase;
	//private static int groundFloor;
	
	public Elevator(ArrayList<Customer> customerBase, int maxFloors,
			int groundFloor) {
		this.customerBase = customerBase;
		this.NUMBER_OF_FLOORS = maxFloors;
		//this.groundFloor = groundFloor;
	}
}
