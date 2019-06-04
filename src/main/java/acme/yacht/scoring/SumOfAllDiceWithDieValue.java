package acme.yacht.scoring;

import acme.yacht.Die;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.function.Function;

@AllArgsConstructor
public class SumOfAllDiceWithDieValue implements Function<List<Die>, Integer> {

    private final Integer dieValue;

    @Override
    public Integer apply(List<Die> dice) {
        return dice.stream()
                .map(Die::getValue)
                .filter(v -> v.equals(dieValue))
                .reduce(0, Integer::sum);
    }
}
