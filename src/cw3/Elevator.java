package cw3;

import java.util.ArrayList;

/**
 * @author fgrami01 & jbukow01
 * 
 */

public class Elevator {

	private final int NUMBER_OF_FLOORS;
	private ArrayList<Customer> customerBase;
	private int currentFloor;
	private boolean top = false;

	public Elevator(ArrayList<Customer> customerBase, int numberOfFloors,
			int startingFloor) {
		this.customerBase = customerBase;
		this.NUMBER_OF_FLOORS = numberOfFloors;
		this.currentFloor = startingFloor;
	}

	public void bottomToTopMove(int numberOfFloors, int startingFloor) {
		System.out.println("Starting floor: " + currentFloor
				+ " Number of floors: " + NUMBER_OF_FLOORS
				+ " Number of customers: " + customerBase.size());
		if (currentFloor != numberOfFloors && !top) {
			for (int i = 0; i < numberOfFloors; i++) {
				for (int j = 0; j < customerBase.size(); j++) {
					if (customerBase.get(j).getStartingFloor() == currentFloor) {
						customerBase.get(j).setInElevator(true);
					}
					for (int k = customerBase.size() - 1; k > 0; k--) {
						if (customerBase.get(k).getDesiredFloor() == currentFloor) {
							customerBase.remove(k);
						}
					}
				}
				currentFloor++;
				System.out.println("Current floor: " + currentFloor
						+ " Number of customers: " + customerBase.size());
			}
			if (currentFloor == numberOfFloors)
				top = true;
		}
		if (top) {
			for (int i = numberOfFloors; i > 0; i--) {
				for (int j = 0; j < customerBase.size(); j++) {
					if (customerBase.get(j).getStartingFloor() == currentFloor) {
						customerBase.get(j).setInElevator(true);
					}
					for (int k = customerBase.size() - 1; k > 0; k--) {
						if (customerBase.get(k).getDesiredFloor() == currentFloor) {
							customerBase.remove(k);
						}
					}
				}
				currentFloor--;
				System.out.println("Current floor: " + currentFloor
						+ " Number of customers: " + customerBase.size());
			}
		}
		System.out.println("Finished. Number of customers in the lift: "
				+ customerBase.size());
	}
}