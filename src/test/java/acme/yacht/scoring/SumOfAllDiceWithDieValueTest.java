package acme.yacht.scoring;

import acme.yacht.Dies;
import junit.framework.TestCase;
import static org.junit.Assert.*;

import org.junit.Test;


public class SumOfAllDiceWithDieValueTest {

	private SumOfAllDiceWithDieValue scoreTwos = new SumOfAllDiceWithDieValue(2);
	private SumOfAllDiceWithDieValue scoreFours = new SumOfAllDiceWithDieValue(4);

	@Test
	public void testBasic() {
		assertEquals(new Integer(0), scoreTwos.apply(Dies.withValues(1, 1, 3, 4)));
		assertEquals(new Integer(4), scoreTwos.apply(Dies.withValues(1, 2, 2, 4)));
		assertEquals(new Integer(8), scoreTwos.apply(Dies.withValues(2, 2, 2, 2)));
		assertEquals(new Integer(8), scoreFours.apply(Dies.withValues(4, 1, 3, 4)));
	}
}
