package acme.yacht.filter;

import acme.yacht.Dies;
import static org.junit.Assert.*;

import org.junit.Test;

public class BigStraightPredicateTest {

	private BigStraightPredicate bigPredicateFilter = new BigStraightPredicate();

	@Test
	public void testBasis() {
		assertFalse(bigPredicateFilter.test(Dies.withValues(2, 2, 3, 4, 5)));
		assertFalse(bigPredicateFilter.test(Dies.withValues(3, 4, 6, 1, 1)));
		assertTrue(bigPredicateFilter.test(Dies.withValues(2, 3, 4, 5, 6)));
		assertTrue(bigPredicateFilter.test(Dies.withValues(6, 5, 4, 3, 2)));
	}
	
	@Test
	public void testBigStraightStartingWith1_shouldNotBeConsideredABigStraight() {
		assertFalse(bigPredicateFilter.test(Dies.withValues(1, 2, 3, 4, 5)));
	}
}
