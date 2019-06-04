package acme.yacht;

import acme.yacht.filter.BigStraightPredicate;
import acme.yacht.filter.DieValuePredicate;
import acme.yacht.filter.FullHousePredicate;
import acme.yacht.filter.NofAKindPredicate;
import acme.yacht.scoring.FixedScore;
import acme.yacht.scoring.SumOfAllDice;
import acme.yacht.scoring.SumOfAllDiceWithDieValue;
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
                        .filterPredicate(new BigStraightPredicate())
                        .scoringFunction(new FixedScore(30))
                        .build(),

                Rule.builder()
                        .category(YachtResultCategory.CHOICE)
                        .filterPredicate((dice) -> true)
                        .scoringFunction(new SumOfAllDice())
                        .build(),

                Rule.builder()
                        .category(YachtResultCategory.FOUR_OF_A_KIND)
                        .filterPredicate(new NofAKindPredicate(4))
                        .scoringFunction(new SumOfNofAKind(4))
                        .build(),

                Rule.builder()
                        .category(YachtResultCategory.FULL_HOUSE)
                        .filterPredicate(new FullHousePredicate())
                        .scoringFunction(new SumOfAllDice())
                        .build(),

                Rule.builder()
                        .category(YachtResultCategory.SIXES)
                        .filterPredicate(new DieValuePredicate(6))
                        .scoringFunction(new SumOfAllDiceWithDieValue(6))
                        .build(),

                Rule.builder()
                        .category(YachtResultCategory.THREES)
                        .filterPredicate(new DieValuePredicate(3))
                        .scoringFunction(new SumOfAllDiceWithDieValue(3))
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
