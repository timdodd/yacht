package acme.yacht;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.Comparator;

@Getter
@ToString
@Builder
public class YachtResult implements Comparable<YachtResult> {

    @NonNull
    private final YachtResultCategory category;
    @NonNull
    private final Integer points;

    public int compareTo(YachtResult other) {
        return Comparator.comparing(YachtResult::getPoints)
                .reversed()
                .thenComparing(YachtResult::getCategory)
                .compare(this, other);
    }

}
