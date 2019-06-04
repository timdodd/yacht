package acme.yacht;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;

@UtilityClass
public class Dies {

    public static Map<Die, Long> counted(List<Die> dice) {
        return dice
                .stream()
                .collect(Collectors.groupingBy(identity(), counting()));
    }

    public static List<Die> withValues(Integer... dieValues) {
        return Arrays.asList(dieValues)
                .stream()
                .map(v -> Die.newStandardDie().setValue(v))
                .collect(Collectors.toList());
    }

    public static List<Integer> values(List<Die> dice) {
        return dice.stream()
                .map(Die::getValue)
                .collect(Collectors.toList());
    }

    public static boolean containsValue(List<Die> dice, Integer dieValue) {
        return dice.stream()
                .map(Die::getValue)
                .anyMatch(v -> v.equals(dieValue));
    }

    public static boolean containsExactly(List<Die> dice, List<Integer> dieValues) {
        List<Integer> expectedValues = dieValues.stream()
                .sorted()
                .collect(Collectors.toList());

        List<Integer> actualValues = values(dice).stream()
                .sorted()
                .collect(Collectors.toList());

        return expectedValues.equals(actualValues);
    }

    public static Integer sum(List<Die> dice) {
        return dice.stream()
                .map(Die::getValue)
                .reduce(0, Integer::sum);
    }

    public static Integer sumHavingDieValue(List<Die> dice, Integer dieValue) {
        return dice.stream()
                .map(Die::getValue)
                .filter(v -> v.equals(dieValue))
                .reduce(0, Integer::sum);
    }
}
