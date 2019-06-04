package acme.yacht.filter;

import acme.yacht.Die;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.function.Predicate;

@AllArgsConstructor
public class DieValuePredicate implements Predicate<List<Die>> {

    private final Integer dieValue;

    public boolean test(List<Die> dice) {
        return dice.stream()
                .map(Die::getValue)
                .anyMatch(v -> v.equals(dieValue));
    }
}
