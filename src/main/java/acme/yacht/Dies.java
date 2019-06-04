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
}
