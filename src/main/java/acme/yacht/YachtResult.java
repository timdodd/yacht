package acme.yacht;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@ToString
@Builder
public class YachtResult {

    @NonNull
    private final YachtResultCategory category;
    @NonNull
    private final Integer points;

}
