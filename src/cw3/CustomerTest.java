package cw3;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author fgrami01 & jbukow01
 *
 */

public class CustomerTest {

	@Test
	public void test() {
		Customer cust1 = new Customer(10, 4, 2);
		assertEquals("ID", 100, Customer.getCustomerId());
		assertEquals("Starting Floor", 4, cust1.getStartingFloor());
		assertEquals("Destination Floor", 2, cust1.getDestinationFloor());
		Customer cust2 = new Customer(30, 8, 22);
		assertEquals("ID", 101, Customer.getCustomerId());
		assertEquals("Starting Floor", 8, cust2.getStartingFloor());
		assertEquals("Destination Floor", 22, cust2.getDestinationFloor());
	}
}
