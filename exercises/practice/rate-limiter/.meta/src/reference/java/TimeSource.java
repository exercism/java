public interface TimeSource {
    long nowNanos();

    final class Fake implements TimeSource {
        private long now;

        public Fake(long startNanos) {
            this.now = startNanos;
        }

        @Override
        public long nowNanos() {
            return now;
        }

        public void advance(long nanos) {
            this.now += nanos;
        }
    }
}

