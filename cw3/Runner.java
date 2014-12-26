/**
 * 
 */
package cw3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author fgrami01 && jbukow01
 *
 */
public class Runner {

	private static ArrayList<Customer> customerBase;
	private static int numberOfFloors;
	private static int numberOfCustomers;
	private static int startingFloor;
	private static int desiredFloor;
	private static int groundFloor;
	private static int building;

	public static void main(String[] args) {

		numberOfFloors = (int) (Math.random() * 30);
		numberOfCustomers = (int) (Math.random() * 10);
		startingFloor = (int) (Math.random() * numberOfFloors);
		desiredFloor = (int) (Math.random() * numberOfFloors);
		createCustomerBase(numberOfCustomers, startingFloor, desiredFloor);
		createBuildingStructure(customerBase, numberOfFloors, groundFloor);
	}

	private static void createCustomerBase(int maxCustomers, int startingFloor, int desiredFloor) {
		for (int i = 0; i < maxCustomers; i++) {
			Customer cust = new Customer(maxCustomers, startingFloor, desiredFloor);
			customerBase.add(cust);
		}
	}
	
	private static void createBuildingStructure(ArrayList<Customer> customerBase,int maxFloors, int groundFloor) {
		 building = new Building(customerBase, maxFloors, groundFloor);
	}
}
