package cache;

import org.junit.Test;

public class LRUCacheTest {

    @Test
    public void testCase1() {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 2);
        cache.put(2, 3);
        cache.put(3, 5);
        cache.put(4, 4);
        cache.put(1, 3);
        cache.put(5, 3);
        cache.get(1);
        cache.traverse();
    }
}
