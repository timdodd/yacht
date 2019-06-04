package acme.yacht;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class YachtsTest {

	@Test
	public void testChoiceOnly() {
		List<YachtResult> results = Yachts.scoreRound(Dies.withValues(1, 2, 2, 5, 5));
		assertEquals(1, results.size());
		assertEquals(YachtResultCategory.CHOICE, results.get(0).getCategory());
		assertEquals(new Integer(15), results.get(0).getPoints());
	}

	@Test
	public void testThreesAndFullHouse() {
		List<YachtResult> results = Yachts.scoreRound(Dies.withValues(3, 3, 5, 5, 5));
		assertEquals(3, results.size());

		assertEquals(YachtResultCategory.FULL_HOUSE, results.get(0).getCategory());
		assertEquals(new Integer(21), results.get(0).getPoints());

		assertEquals(YachtResultCategory.CHOICE, results.get(1).getCategory());
		assertEquals(new Integer(21), results.get(1).getPoints());

		assertEquals(YachtResultCategory.THREES, results.get(2).getCategory());
		assertEquals(new Integer(6), results.get(2).getPoints());
	}

	@Test
	public void testBigStraight() {
		List<YachtResult> results = Yachts.scoreRound(Dies.withValues(3, 4, 5, 6, 2));
		assertEquals(4, results.size());

		assertEquals(YachtResultCategory.BIG_STRAIGHT, results.get(0).getCategory());
		assertEquals(new Integer(30), results.get(0).getPoints());

		assertEquals(YachtResultCategory.CHOICE, results.get(1).getCategory());
		assertEquals(new Integer(20), results.get(1).getPoints());

		assertEquals(YachtResultCategory.SIXES, results.get(2).getCategory());
		assertEquals(new Integer(6), results.get(2).getPoints());

		assertEquals(YachtResultCategory.THREES, results.get(3).getCategory());
		assertEquals(new Integer(3), results.get(3).getPoints());
	}

	@Test
	public void testFourOfAKind() {
		List<YachtResult> results = Yachts.scoreRound(Dies.withValues(2, 2, 4, 2, 2));
		assertEquals(2, results.size());

		assertEquals(YachtResultCategory.CHOICE, results.get(0).getCategory());
		assertEquals(new Integer(12), results.get(0).getPoints());

		assertEquals(YachtResultCategory.FOUR_OF_A_KIND, results.get(1).getCategory());
		assertEquals(new Integer(8), results.get(1).getPoints());
	}
}
