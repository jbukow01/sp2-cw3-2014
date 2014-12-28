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
	private static int startingFloor;

	public static void main(String[] args) {

		numberOfFloors = (int) (Math.random() * 30);
		numberOfCustomers = (int) (Math.random() * 100);

		customerBase = new ArrayList<Customer>();

		createCustomerBase(numberOfCustomers, numberOfFloors);
		createBuildingStructure(customerBase, numberOfFloors, startingFloor);

		building.elevator.bottomToTopMove(numberOfFloors, 4);
	}

	private static void createCustomerBase(int maxCustomers, int maxFloors) {
		for (int i = 0; i < maxCustomers; i++) {
			Customer cust = new Customer((int) (Math.random() * maxFloors),
					(int) (Math.random() * maxFloors));
			if (cust.getStartingFloor() != cust.getDesiredFloor()) {
				customerBase.add(cust);
			}
		}
	}

	private static void createBuildingStructure(
			ArrayList<Customer> customerBase, int maxFloors, int startingFloor) {
		building = new Building(customerBase, maxFloors, startingFloor);
	}
}