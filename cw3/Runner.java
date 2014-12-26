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
	private static int desiredFloor;
	private static int groundFloor;

	public static void main(String[] args) {

		numberOfFloors = (int) (Math.random() * 30) + 2;
		numberOfCustomers = (int) (Math.random() * 9) + 1;;
		startingFloor = (int) (Math.random() * numberOfFloors);
		desiredFloor = (int) (Math.random() * numberOfFloors);
		customerBase = new ArrayList<Customer>();
		createCustomerBase(numberOfCustomers, startingFloor, desiredFloor);
		createBuildingStructure(customerBase, numberOfFloors, groundFloor);
		
		building.elevator.bottomToTopMove(numberOfFloors);
	}

	private static void createCustomerBase(int maxCustomers, int startingFloor, int desiredFloor) {
		for (int i = 0; i < maxCustomers; i++) {
			Customer cust = new Customer(maxCustomers, startingFloor, desiredFloor);
				customerBase.add(cust);
		}
	}
	
	private static void createBuildingStructure(ArrayList<Customer> customerBase,
			int maxFloors, int groundFloor) {
		building = new Building(customerBase, maxFloors, groundFloor);
	}
}