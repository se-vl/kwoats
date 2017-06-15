package kwoats;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RandomNumberServiceTest {
	private RandomNumberService randomNumberService = new RandomNumberService();

	@Test
	public void testNoPrevious() {
		assertEquals(0, randomNumberService.pickRandomNumber(1, null));
	}

	@Test
	public void testPreviousWas0() {
		assertEquals(1, randomNumberService.pickRandomNumber(2, 0));
	}

	@Test
	public void testPreviousWas1() {
		assertEquals(0, randomNumberService.pickRandomNumber(2, 1));
	}
}
