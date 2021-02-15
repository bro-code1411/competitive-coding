package cache;

import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Implement LRU cache of a given max capacity and expose get and put methods.
 *
 * get: retrieves the least recently used key in cache
 * put: to insert/update a key in cache
 */
class Node {
    int key;
    int value;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    private final Integer CACHE_SIZE;
    private Deque<Node> deque;
    private HashMap<Integer, Node> map;

    LRUCache(int capacity) {
        deque = new LinkedList<>();
        CACHE_SIZE = capacity;
        map = new HashMap<>();
    }

    public Integer get(int k) {
        if (map.containsKey(k)) {
            Node n = map.get(k);
            deque.remove(n);
            deque.push(n);
            return n.value;
        }
        return null;
    }

    public void put(int k, int v) {
        if (map.containsKey(k)) {
            Node n = map.get(k);
            deque.remove(n);
        } else if (map.size() == CACHE_SIZE) {
            Node rem= deque.getLast();
            map.remove(rem.key);
            deque.removeLast();
        }
        Node node = new Node(k, v);
        map.put(k,node);
        deque.push(node);
    }

    public void traverse() {
        Iterator<Node> itr = deque.iterator();
        while (itr.hasNext()) {
            Node a =itr.next();
            System.out.println(a.key +" "+a.value);
        }
    }
}

public class LRU {
    public static void main(String[] args) {

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
