package acme.yacht.filter;

import acme.yacht.Die;
import acme.yacht.Dies;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class FullHousePredicate implements Predicate<List<Die>> {

    public boolean test(List<Die> dice) {
        Map<Die, Long> dieCounts = Dies.counted(dice);
        return dieCounts.size() == 2 && dieCounts.values().containsAll(Arrays.asList(2L, 3L));
    }
}