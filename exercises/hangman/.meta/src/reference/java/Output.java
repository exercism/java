import java.util.List;
import java.util.Set;

class Output {

    public final String secret;
    public final String discovered;
    public final Set<String> guess;
    public final Set<String> misses;
    public final List<Part> parts;
    public final Status status;

    Output(
        final String secret,
        final String discovered,
        final Set<String> guess,
        final Set<String> misses,
        final List<Part> parts,
        final Status status) {
        this.secret = secret;
        this.discovered = discovered;
        this.guess = guess;
        this.misses = misses;
        this.parts = parts;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Output{" +
            "secret='" + secret + '\'' +
            ", discovered='" + discovered + '\'' +
            ", guess=" + guess +
            ", misses=" + misses +
            ", parts=" + parts +
            ", status=" + status +
            '}';
    }
}
