import io.reactivex.Observable;

import java.util.List;
import java.util.Set;

class Hangman {

    static Observable<Output> play(final Observable<String> words, final Observable<String> letters) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    static class Output {
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
    }

    enum Status {
        PLAYING,
        WIN,
        LOSS
    }

    enum Part {
        HEAD,
        BODY,
        LEFT_ARM,
        RIGHT_ARM,
        LEFT_LEG,
        RIGHT_LEG
    }

    static final Part[] ORDER = Part.values();

}
