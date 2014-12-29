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
		this.movements = 0;
		this.direction = 0;
	}

	/**
	 * Moves the elevator according to which option of move the user chooses
	 * 
	 * @param option
	 *            move option chosen by the user
	 * @param numberOfFloors
	 * @param startingFloor
	 */

	public void run(int option) {
		System.out.println("----------------");
		System.out.println("Strategy used: " + option);
		int leftStarting = Runner.numberOfCustomers - customerList.size();
		System.out.println("Number of customer that left on the starting floor: " + leftStarting);
		System.out.println("Starting floor: " + currentFloor
				+ " Number of floors: " + NUMBER_OF_FLOORS
				+ " Number of customers waiting: " + customerList.size());
		System.out.println("Current floor: " + currentFloor
				+ " Number of customers waiting: " + customerList.size());
		while (!customerList.isEmpty()) {
			customerJoins();
			customerLeaves();
			if (option == 1) {
				defaultStrategy();
			} else if (option == 2) {
				otherStrategy();
			}
		}
		System.out.println("Finished at floor: " + currentFloor + ". Total number of moves: " + movements);
	}

	/**
	 * Moves elevator from starting floor to the top of the building, picking up
	 * and dropping customers off in desired floors. It moves from starting
	 * floor to the last floor and then all the way down and up again till there
	 * is no customers waiting. Tracks the number of moves done by elevator
	 */

	public void defaultStrategy() {

		if (direction == 0) {
			if (currentFloor < NUMBER_OF_FLOORS) {
				direction = 1;
			} else {
				direction = -1;
			}
		}
		if (direction == 1 && currentFloor == NUMBER_OF_FLOORS) {
			direction = -1;
		} else if (direction == -1 && currentFloor == 0) {
			direction = 1;
		}

		currentFloor += direction;
		movements++;
		System.out.println("Current floor: " + currentFloor
				+ " Number of customers waiting: " + customerList.size());
	}

	/**
	 * Moves elevator from a starting floor to the next floor up if there is a
	 * customer waiting to be dropped off or picked in, otherwise it's going
	 * down to lower floors where customers are waiting and then up again. The
	 * elevator is not going higher or lower than customers starting/destination
	 * floors. Tracks the number of moves done by elevator
	 */

	public void otherStrategy() {
		for (int i = 0; i < customerList.size(); i++)
			if (customerList.get(i).isInElevator()
					&& customerList.get(i).getDestinationFloor() > currentFloor) {
				direction = +1;
			} else if (!customerList.get(i).isInElevator()
					&& customerList.get(i).getStartingFloor() > currentFloor) {
				direction = +1;
			} else {
				direction = -1;
			}

		currentFloor += direction;
		movements++;
		if (currentFloor == -1) {
			currentFloor++;
		}
		System.out.println("Current floor: " + currentFloor
				+ " Number of customers waiting: " + customerList.size());
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