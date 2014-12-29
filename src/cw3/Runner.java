package cw3;

import java.util.ArrayList;

/**
 * @author fgrami01 & jbukow01
 * 
 */

public class Runner {

	private static ArrayList<Customer> customerList;
	private static Building building;
	private static int numberOfFloors;
	private static int numberOfCustomers;

	public static void main(String[] args) {

		numberOfFloors = randomFloor(5, 30);
		numberOfCustomers = (int) (Math.random() * 10);

		customerList = new ArrayList<Customer>();

		createCustomerList(numberOfCustomers, numberOfFloors);
		createBuildingStructure(customerList, numberOfFloors);

		building.elevator.run(2);
	}

	/**
	 * Adds a set of customers to the customerList Sets a random start and end
	 * destination floors for each customer If start and end floors are the
	 * same, then the customer is not added to the list
	 * 
	 * @param numberOfCustomers
	 *            number of customers to be added to the elevator as chosen by
	 *            user
	 * @param numberOfFloors
	 */

	private static void createCustomerList(int numberOfCustomers,
			int numberOfFloors) {
		for (int i = 0; i < numberOfCustomers; i++) {
			Customer cust = new Customer(numberOfFloors, randomFloor(0,
					numberOfFloors), randomFloor(0, numberOfFloors));
			if (cust.getStartingFloor() != cust.getDestinationFloor()) {
				customerList.add(cust);
			}
		}
	}

	/**
	 * Creates a building
	 * 
	 * @param customerList
	 * @param numberOfFloors
	 */

	private static void createBuildingStructure(
			ArrayList<Customer> customerList, int numberOfFloors) {
		building = new Building(customerList, numberOfFloors, randomFloor(0,
				numberOfFloors));
	}

	/**
	 * Returns a random number between start and end 13 cannot be assigned as
	 * start or end
	 * 
	 * @param start
	 *            the floor in which the customer starts
	 * @param end
	 *            the floor in which the customer leaves the elevator
	 * @return
	 */
	public static int randomFloor(int start, int end) {
		int range = (end - start) + 1;
		int floor = start + (int) (Math.random() * range);
		if (floor == 13) {
			floor++;
		}
		return floor;
	}
}
