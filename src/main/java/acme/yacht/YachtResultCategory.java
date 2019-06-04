package acme.yacht;

import lombok.Getter;

public enum YachtResultCategory {

    FULL_HOUSE("Full House"),
    FOUR_OF_A_KIND("Four of a kind"),
    BIG_STRAIGHT("Big straight"),
    THREES("Threes"),
    SIXES("Sixes"),
    CHOICE("Choice");

    @Getter
    private final String description;

    YachtResultCategory(String description) {
        this.description = description;
    }
}
