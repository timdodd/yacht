package acme.yacht;

import acme.yacht.filter.FullHousePredicate;
import acme.yacht.filter.NofAKindPredicate;
import acme.yacht.scoring.SumOfNofAKind;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@UtilityClass
public class RuleDefinitions {

    private static List<Rule> rules = getInitializedRules();

    public static List<Rule> getRules() {
        return rules;
    }

    private static List<Rule> getInitializedRules() {
        return Arrays.asList(
                Rule.builder()
                        .category(YachtResultCategory.BIG_STRAIGHT)
                        .filterPredicate((dice) -> Dies.containsExactly(dice, Arrays.asList(2, 3, 4, 5, 6)))
                        .scoringFunction((dice) -> 30)
                        .build(),

                Rule.builder()
                        .category(YachtResultCategory.CHOICE)
                        .filterPredicate((dice) -> true)
                        .scoringFunction(Dies::sum)
                        .build(),

                Rule.builder()
                        .category(YachtResultCategory.FOUR_OF_A_KIND)
                        .filterPredicate(new NofAKindPredicate(4))
                        .scoringFunction(new SumOfNofAKind(4))
                        .build(),

                Rule.builder()
                        .category(YachtResultCategory.FULL_HOUSE)
                        .filterPredicate(new FullHousePredicate())
                        .scoringFunction(Dies::sum)
                        .build(),

                Rule.builder()
                        .category(YachtResultCategory.SIXES)
                        .filterPredicate((dice) -> Dies.containsValue(dice, 6))
                        .scoringFunction((dice) -> Dies.sumHavingDieValue(dice, 6))
                        .build(),

                Rule.builder()
                        .category(YachtResultCategory.THREES)
                        .filterPredicate((dice) -> Dies.containsValue(dice, 3))
                        .scoringFunction((dice) -> Dies.sumHavingDieValue(dice, 3))
                        .build()
        );
    }

    @Builder
    @Getter
    public static class Rule {

        @NonNull
        private final YachtResultCategory category;
        @NonNull
        private final Predicate<List<Die>> filterPredicate;
        @NonNull
        private final Function<List<Die>, Integer> scoringFunction;
    }

}
