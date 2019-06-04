package acme.yacht;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(of = "value")
@ToString(of = "value")
public class Die {

    private final List<Integer> possibleValues;
    private Integer value;

    private Die(Integer... possibleValues) {
        this.possibleValues = Arrays.asList(possibleValues);
    }

    public static Die newStandardDie() {
        return new Die(1, 2, 3, 4, 5, 6);
    }

    public Integer roll() {
        Collections.shuffle(possibleValues);
        return possibleValues.get(0);
    }
}
