package cw3;

import java.util.ArrayList;

/**
 * @author fgrami01 & jbukow01
 * 
 */

public class Runner {

	private static ArrayList<Customer> customerBase;
	private static Building building;
	private static int numberOfFloors;
	private static int numberOfCustomers;

	public static void main(String[] args) {

		numberOfFloors = randomFloor(5, 30);
		numberOfCustomers = (int) (Math.random() * 10);

		customerBase = new ArrayList<Customer>();

		createCustomerBase(numberOfCustomers, numberOfFloors);
		createBuildingStructure(customerBase, numberOfFloors);

		building.elevator.bottomToTopMove(numberOfFloors, 4);
	}

	private static void createCustomerBase(int numberOfCustomers, int numberOfFloors) {
		for (int i = 0; i < numberOfCustomers; i++) {
			Customer cust = new Customer(numberOfFloors, randomFloor(0,
					numberOfFloors), randomFloor(0, numberOfFloors));
			if (cust.getStartingFloor() != cust.getDesiredFloor()) {
				customerBase.add(cust);
			}
		}
	}

	private static void createBuildingStructure(
			ArrayList<Customer> customerBase, int numberOfFloors) {
		building = new Building(customerBase, numberOfFloors, randomFloor(0,
				numberOfFloors));
	}

	public static int randomFloor(int start, int end) {
		int range = (end - start) + 1;
		int floor = start + (int) (Math.random() * range);

		if (floor == 13) {
			floor++;
		}
		return floor;
	}
}