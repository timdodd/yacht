package acme.yacht.filter;

import org.junit.Test;

import acme.yacht.Dies;
import static org.junit.Assert.*;

public class FullHousePredicateTest {

	private FullHousePredicate fullHousePredicate = new FullHousePredicate();

	@Test
	public void testBasis() {
		assertFalse(fullHousePredicate.test(Dies.withValues(2, 2, 2, 2, 5)));
		assertFalse(fullHousePredicate.test(Dies.withValues(3, 4, 6, 1, 1)));
		assertTrue(fullHousePredicate.test(Dies.withValues(2, 2, 2, 6, 6)));
		assertTrue(fullHousePredicate.test(Dies.withValues(3, 2, 3, 3, 2)));
	}
}
