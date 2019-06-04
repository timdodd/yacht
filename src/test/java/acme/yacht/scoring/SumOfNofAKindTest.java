package acme.yacht.scoring;

import acme.yacht.Dies;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumOfNofAKindTest {

	private SumOfNofAKind scoringFunction = new SumOfNofAKind(4);

	@Test
	public void testBasic() {
		assertEquals(new Integer(0), scoringFunction.apply(Dies.withValues(1, 1, 3, 4)));
		assertEquals(new Integer(8), scoringFunction.apply(Dies.withValues(2, 2, 2, 4, 2)));
		assertEquals(new Integer(8), scoringFunction.apply(Dies.withValues(2, 2, 2, 2, 2)));
	}
}
