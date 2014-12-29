package cw3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author fgrami01 & jbukow01
 * 
 */

public class Runner {

	private static ArrayList<Customer> customerList;
	private static Building building;
	private static int numberOfFloors;
	static int numberOfCustomers;
	private static Scanner nof;
	private static Scanner noc;
	private static Scanner optionCheck;

	public static void main(String[] args) {

		System.out.print("Please enter number of floors: ");
		nof = new Scanner(System.in);
		while (!nof.hasNextInt()) {
			System.out.print("Please enter number of floors: ");
			nof.next();
		}
		numberOfFloors = nof.nextInt();

		System.out.print("Please enter number of customers: ");
		noc = new Scanner(System.in);
		while (!noc.hasNextInt()) {
			System.out.print("Please enter number of customers: ");
			noc.next();
		}
		numberOfCustomers = noc.nextInt();

		System.out.print("Please enter strategy option (1, 2): ");
		optionCheck = new Scanner(System.in);
		while (!optionCheck.hasNextInt()) {
			System.out.print("Please choose option 1 or 2: ");
			optionCheck.next();
		}
		int option = optionCheck.nextInt();
		while (option != 1 && option != 2) {
			System.out.print("Please choose option 1 or 2: ");
			option = optionCheck.nextInt();

		}

		customerList = new ArrayList<Customer>();

		createCustomerList(numberOfCustomers, numberOfFloors);
		createBuildingStructure(customerList, numberOfFloors);

		building.elevator.run(option);
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