package acme.yacht;

import lombok.experimental.UtilityClass;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class Yachts {

    public static List<YachtResult> options(List<Die> dice) {
        return RuleDefinitions.getRules()
                .stream()
                .filter(rule -> rule.getFilterPredicate().test(dice))
                .map(rule -> YachtResult.builder()
                        .category(rule.getCategory())
                        .points(rule.getScoringFunction().apply(dice))
                        .build())
                .sorted(Comparator.comparing(YachtResult::getPoints).reversed().thenComparing(YachtResult::getCategory))
                .collect(Collectors.toList());
    }

}
