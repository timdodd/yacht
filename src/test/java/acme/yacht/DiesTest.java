package acme.yacht;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class DiesTest {


    @Test
    public void testContainsValue() {
        assertTrue(Dies.containsValue(Dies.withValues(2, 2, 2, 2, 5), 2));
        assertFalse(Dies.containsValue(Dies.withValues(2, 2, 2, 2, 5), 3));
    }

    @Test
    public void testContainsExactly() {
        assertTrue(Dies.containsExactly(Dies.withValues(3, 1, 2), Arrays.asList(1, 2, 3)));
        assertTrue(Dies.containsExactly(Dies.withValues(3, 3, 2), Arrays.asList(2, 3, 3)));
        assertFalse(Dies.containsExactly(Dies.withValues(3, 1, 2), Arrays.asList(1, 3, 3)));
    }

    @Test
    public void testSum() {
        assertEquals(new Integer(6), Dies.sum(Dies.withValues(3, 1, 2)));
        assertEquals(new Integer(10), Dies.sum(Dies.withValues(3, 3, 1, 2, 1)));
    }

    @Test
    public void sumHavingDieValue() {
        assertEquals(new Integer(3), Dies.sumHavingDieValue(Dies.withValues(3, 1, 2), 3));
        assertEquals(new Integer(6), Dies.sumHavingDieValue(Dies.withValues(3, 3, 1, 2, 1), 3));
    }

}
