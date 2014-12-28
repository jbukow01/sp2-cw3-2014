package cw3;

import java.util.ArrayList;

/**
 * @author fgrami01 & jbukow01
 * 
 */

public class Elevator {

	private final int NUMBER_OF_FLOORS;
	private ArrayList<Customer> customerList;
	private int currentFloor;
	private boolean top = false;
	private int movements;
	
	/**
	 * @param customerList
	 * @param numberOfFloors
	 * @param startingFloor
	 */

	public Elevator(ArrayList<Customer> customerList, int numberOfFloors,
			int startingFloor) {
		this.customerList = customerList;
		this.NUMBER_OF_FLOORS = numberOfFloors;
		this.currentFloor = startingFloor;
	}
	
	/**
	 * @param numberOfFloors
	 * @param startingFloor
	 */

	public void bottomToTopMove(int numberOfFloors, int startingFloor) {
		System.out.println("Starting floor: " + currentFloor
				+ " Number of floors: " + NUMBER_OF_FLOORS
				+ " Number of customers: " + customerList.size());
		if (currentFloor != numberOfFloors && !top) {
			for (int i = 0; i < numberOfFloors; i++) {
				for (int j = 0; j < customerList.size(); j++) {
					if (customerList.get(j).getStartingFloor() == currentFloor) {
						customerList.get(j).setInElevator(true);
					}
					for (int k = customerList.size() - 1; k > 0; k--) {
						if (customerList.get(k).getDestinationFloor() == currentFloor) {
							customerList.remove(k);
						}
					}
				}
				currentFloor++;
				movements++;
				System.out.println("Current floor: " + currentFloor
						+ " Number of customers: " + customerList.size());
			}
			if (currentFloor == numberOfFloors)
				top = true;
		}
		if (top) {
			for (int i = numberOfFloors; i > 0; i--) {
				for (int j = 0; j < customerList.size(); j++) {
					if (customerList.get(j).getStartingFloor() == currentFloor) {
						customerList.get(j).setInElevator(true);
					}
					for (int k = customerList.size() - 1; k > 0; k--) {
						if (customerList.get(k).getDestinationFloor() == currentFloor) {
							customerList.remove(k);
						}
					}
				}
				currentFloor--;
				movements++;
				System.out.println("Current floor: " + currentFloor
						+ " Number of customers: " + customerList.size());
			}
		}
		System.out.println("Finished. Total number of moves: " + movements);
	}
}