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

		createCustomerBase(numberOfCustomers, numberOfFloors);
		createBuildingStructure(customerList, numberOfFloors);

		building.elevator.run(1, numberOfFloors, 0);
	}
	
	/**
	 * @param numberOfCustomers
	 * @param numberOfFloors
	 */

	private static void createCustomerBase(int numberOfCustomers, int numberOfFloors) {
		for (int i = 0; i < numberOfCustomers; i++) {
			Customer cust = new Customer(numberOfFloors, randomFloor(0,
					numberOfFloors), randomFloor(0, numberOfFloors));
			if (cust.getStartingFloor() != cust.getDestinationFloor()) {
				customerList.add(cust);
			}
		}
	}
	
	/**
	 * @param customerList
	 * @param numberOfFloors
	 */

	private static void createBuildingStructure(
			ArrayList<Customer> customerList, int numberOfFloors) {
		building = new Building(customerList, numberOfFloors, randomFloor(0,
				numberOfFloors));
	}
	
	/**
	 * @param start
	 * @param end
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