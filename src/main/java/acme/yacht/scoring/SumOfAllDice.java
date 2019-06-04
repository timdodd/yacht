package acme.yacht.scoring;

import acme.yacht.Die;

import java.util.List;
import java.util.function.Function;

public class SumOfAllDice implements Function<List<Die>, Integer> {

    @Override
    public Integer apply(List<Die> dice) {
        return dice.stream()
                .map(Die::getValue)
                .reduce(0, Integer::sum);
    }
}
