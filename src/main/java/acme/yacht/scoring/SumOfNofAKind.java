package acme.yacht.scoring;

import acme.yacht.Die;
import acme.yacht.Dies;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

@AllArgsConstructor
public class SumOfNofAKind implements Function<List<Die>, Integer> {

    private int n;

    @Override
    public Integer apply(List<Die> dice) {
        Map<Die, Long> counted = Dies.counted(dice);
        return counted.entrySet()
                .stream()
                .filter(v -> v.getValue().intValue() >= n)
                .map(e -> e.getKey().getValue() * e.getValue().intValue())
                .sorted()
                .findFirst()
                .orElse(0);
    }
}
