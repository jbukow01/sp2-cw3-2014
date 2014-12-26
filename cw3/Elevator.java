package cw3;

import java.util.ArrayList;

/**
 * @author fgrami01 & jbukow01
 *
 */

public class Elevator {

	private final int NUMBER_OF_FLOORS;
	private ArrayList<Customer> customerBase;
	// private static int groundFloor;
	private int currentFloor;
	private boolean top = false;

	public Elevator(ArrayList<Customer> customerBase, int maxFloors,
			int groundFloor) {
		this.customerBase = customerBase;
		this.NUMBER_OF_FLOORS = maxFloors;
		// this.groundFloor = groundFloor;
	}

	public void bottomToTopMove(int maxFloors) {
		currentFloor = 0;
		System.out.println("Starting floor: " + currentFloor + " Number of customers: " + customerBase.size());
		if (currentFloor != maxFloors && !top) {
			for (int i = 0; i < customerBase.size(); i++) {
				if (customerBase.get(i).getStartingFloor() == currentFloor) {
					customerBase.get(i).setInElevator(true);
				}
				if (customerBase.get(i).getDesiredFloor() == currentFloor) {
					customerBase.remove(i);
				}
			}
			currentFloor++;
			if (currentFloor == maxFloors)
				top = true;
		}
		else if (top) {
			for (int i = 0; i < customerBase.size(); i++) {
				if (customerBase.get(i).getStartingFloor() == currentFloor) {
					customerBase.get(i).setInElevator(true);
				}
				if (customerBase.get(i).getDesiredFloor() == currentFloor) {
					customerBase.remove(i);
				}
			}
			currentFloor--;
		}
	}
}