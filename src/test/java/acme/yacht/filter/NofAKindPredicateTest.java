package acme.yacht.filter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import acme.yacht.Dies;

public class NofAKindPredicateTest {

	private NofAKindPredicate fourOfAKindPrediate = new NofAKindPredicate(4);

	@Test
	public void testBasis() {
		assertFalse(fourOfAKindPrediate.test(Dies.withValues(2, 3, 5, 2, 5)));
		assertFalse(fourOfAKindPrediate.test(Dies.withValues(3, 4, 6, 1, 1)));
		assertTrue(fourOfAKindPrediate.test(Dies.withValues(2, 2, 2, 6, 2)));
		assertTrue(fourOfAKindPrediate.test(Dies.withValues(3, 2, 3, 3, 3)));
	}
}
