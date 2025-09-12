public interface RateLimiter<K> {
    boolean allow(K key);
}
