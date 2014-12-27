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
		this.currentFloor = groundFloor;
	}

	public void bottomToTopMove(int maxFloors) {
		currentFloor = 0;
		int custStartNumber = customerBase.size();
		System.out.println("Starting floor: " + currentFloor
				+ " Number of floors: " + NUMBER_OF_FLOORS
				+ " Number of customers: " + customerBase.size());
		if (currentFloor != maxFloors && !top) {
			for (int i = 0; i < maxFloors; i++) {
				for (int j = 0; j < customerBase.size(); j++) {
					if (customerBase.get(j).getStartingFloor() == currentFloor) {
						customerBase.get(j).setInElevator(true);
					}
					if (customerBase.get(j).getDesiredFloor() == currentFloor) {
						customerBase.remove(j);
					}
				}
				currentFloor++;
				System.out.println("Current floor: " + currentFloor
						+ " Number of customers: " + customerBase.size());
			}
			if (currentFloor == maxFloors)
				top = true;
			System.out.println(currentFloor);
			System.out.println(maxFloors);
			System.out.println(top);
		}
		if (top) {
			for (int i = 0; i < maxFloors; i++) {
				for (int j = 0; j < customerBase.size(); j++) {
					if (customerBase.get(j).getStartingFloor() == currentFloor) {
						customerBase.get(j).setInElevator(true);
					}
					if (customerBase.get(j).getDesiredFloor() == currentFloor) {
						customerBase.remove(j);
					}
				}
				currentFloor--;
				System.out.println("Current floor: " + currentFloor
						+ " Number of customers: " + customerBase.size());
			}
		}
		System.out.println(currentFloor);
		System.out.println(maxFloors);
		System.out.println(top);
		System.out.println("Finished. Number of customers in the lift: "
				+ customerBase.size());
	}
}