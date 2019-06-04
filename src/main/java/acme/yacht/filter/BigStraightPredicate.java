package acme.yacht.filter;

import acme.yacht.Die;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BigStraightPredicate implements Predicate<List<Die>> {

    public boolean test(List<Die> dice) {
        return dice.stream()
                .map(Die::getValue)
                .collect(Collectors.toList()).containsAll(Arrays.asList(2, 3, 4, 5, 6));
    }
}