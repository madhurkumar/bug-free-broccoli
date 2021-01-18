package bug.free.broccoli.algoexpert;

import lombok.ToString;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class AeVH1 {
    static class LRUCache {
        Map<String, Integer> store;
        Deque<String> deque;
        int currentSize = 0;
        int maxSize;

        public LRUCache(int maxSize) {
            this.maxSize = Math.max(maxSize, 1);
            this.store = new HashMap<>(this.maxSize);
            this.deque = new ArrayDeque<>(this.maxSize);
        }

        public void insertKeyValuePair(String key, int value) {
            if (this.currentSize == this.maxSize) {
                String k = deque.removeLast();
                store.remove(k);
                this.currentSize--;
            }
            store.put(key, value);
            deque.addFirst(key);
            this.currentSize++;
        }

        public LRUResult getValueFromKey(String key) {
            Integer r = store.get(key);
            if (r != null) {
                this.deque.remove(key);
                this.deque.addFirst(key);
            }
            return new LRUResult(r != null, r == null ? 0 : r);
        }

        public String getMostRecentKey() {
            return this.deque.getFirst();
        }
    }

    @ToString
    static class LRUResult {
        boolean found;
        int value;

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.insertKeyValuePair("b", 2);
        lruCache.insertKeyValuePair("a", 1);
        lruCache.insertKeyValuePair("c", 3);
        System.out.println(lruCache.getMostRecentKey());
        System.out.println(lruCache.getValueFromKey("a"));
        lruCache.insertKeyValuePair("d", 4);
        System.out.println(lruCache.getValueFromKey("b"));
        System.out.println(lruCache.getMostRecentKey());
    }


}
