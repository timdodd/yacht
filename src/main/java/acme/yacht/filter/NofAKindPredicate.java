package acme.yacht.filter;

import acme.yacht.Die;
import acme.yacht.Dies;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class NofAKindPredicate implements Predicate<List<Die>> {

    private final int n;

    public NofAKindPredicate(int n) {
        this.n = n;
    }

    public boolean test(List<Die> dice) {
        Map<Die, Long> dieCounts = Dies.counted(dice);
        return dieCounts.values()
                .stream()
                .anyMatch(count -> count.intValue() >= n);
    }
}
