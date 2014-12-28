package cw3;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

/**
 * @author fgrami01 & jbukow01
 *
 */

public class ElevatorTest {

	@Test
	public void test() {
		Customer cust = new Customer(2, 4);
		ArrayList<Customer> customersBase = new ArrayList<Customer>();
		customersBase.add(cust);
		Elevator elevator = new Elevator(customersBase, 8, 0);
		elevator.bottomToTopMove(8, 4);
		assertEquals("one customer going up", 8);
	}
}
