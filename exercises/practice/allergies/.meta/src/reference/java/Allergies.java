import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

class Allergies {

    private int score;

    Allergies(int score) {
        this.score = score;
    }

    List<Allergen> getList() {
        return EnumSet.allOf(Allergen.class).stream()
                .filter(this::isAllergicTo)
                .collect(Collectors.toList());
    }

    boolean isAllergicTo(Allergen allergen) {
        return (score & allergen.getScore()) != 0;
    }
}
