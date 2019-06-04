package acme.yacht.scoring;

import acme.yacht.Die;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.function.Function;

@AllArgsConstructor
public class FixedScore implements Function<List<Die>, Integer> {

    private final Integer fixedScore;

    @Override
    public Integer apply(List<Die> dice) {
        return fixedScore;
    }
}
