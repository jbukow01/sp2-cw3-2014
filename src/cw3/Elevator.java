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
	private int direction;

	/**
	 * Creates elevator with customer list, number of floors and starting floor
	 * 
	 * @param customerList
	 * @param numberOfFloors
	 * @param startingFloor
	 */

	public Elevator(ArrayList<Customer> customerList, int numberOfFloors,
			int startingFloor) {
		this.customerList = customerList;
		this.NUMBER_OF_FLOORS = numberOfFloors;
		this.currentFloor = startingFloor;
		movements = 0;
		direction = 1;
	}

	/**
	 * Moves the elevator according to which option of move the user chooses
	 * 
	 * @param option
	 *            move option chosen by the user
	 * @param numberOfFloors
	 * @param startingFloor
	 */
	public void run(int option, int numberOfFloors, int startingFloor) {
		System.out.println("Starting floor: " + currentFloor
				+ " Number of floors: " + NUMBER_OF_FLOORS
				+ " Number of customers: " + customerList.size());
		if (option == 1) {
			defaultStrategy();
		} else if (option == 2) {
			// otherStrategy();
		} else {
			System.out.println("Please choose correct option! Options: (1, 2)");
		}
		System.out.println("Finished. Total number of moves: " + movements);
	}

	public void move() {

		if (direction == 1 && currentFloor == NUMBER_OF_FLOORS) {
			direction = -1;
		} else if (direction == -1 && currentFloor == 0) {
			direction = 1;
		}

		currentFloor += direction;
		movements++;
		System.out.print("Current floor: " + currentFloor);
		System.out.println(" Number of customers: " + customerList.size());
	}

	/**
	 * Moves elevator from bottom to the top of the building, picking up and
	 * dropping customers off in desired floors. It moves from floor to floor
	 * going up and down, even if there is no customer to pick up or drop off.
	 * Tracks the number of moves done by elevator
	 * 
	 * @param numberOfFloors
	 * @param startingFloor
	 */
	public void defaultStrategy() {
		while (!customerList.isEmpty()) {
			customerJoins();
			customerLeaves();
			for (int i = 0; i < customerList.size(); i++)
				if (customerList.get(i).isInElevator()) {
					direction = 1;
				} else if (customerList.get(i).getStartingFloor() > currentFloor) {
					direction = 1;
				} else {
					direction = -1;
				}
			
			currentFloor = currentFloor + direction;
			movements++;
			System.out.println("Current floor: " + currentFloor
					+ " Number of customers: " + customerList.size());
		}
	}

	private void otherMove() {
		// otherMove
	}

	/**
	 * Customer goes into the elevator
	 * 
	 */
	public void customerJoins() {
		for (int i = 0; i < customerList.size(); i++) {
			if (customerList.get(i).getStartingFloor() == currentFloor) {
				customerList.get(i).setInElevator(true);
			}
		}
	}

	/**
	 * Customer leaves the elevator
	 * 
	 */
	public void customerLeaves() {
		for (int i = customerList.size() - 1; i >= 0; i--) {
			if (customerList.get(i).getDestinationFloor() == currentFloor
					&& customerList.get(i).isInElevator()) {
				customerList.remove(i);
			}
		}
	}
}
