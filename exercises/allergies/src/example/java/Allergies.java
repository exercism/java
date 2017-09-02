import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public class Allergies {

    private int score;

    public Allergies(int score) {
        this.score = score;
    }

    public List<Allergen> getList() {
        return EnumSet.allOf(Allergen.class).stream()
                .filter(this::isAllergicTo)
                .collect(Collectors.toList());
    }

    public boolean isAllergicTo(Allergen allergen) {
        return (score & allergen.getScore()) == allergen.getScore();
    }
}
