import java.util.*;

public class LRU_Cache {
    private static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;
        Entry<K, V> priv;
        
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.priv = null;
        }
    }
    
    private Entry<Integer, Integer> head;
    private Map<Integer, Entry<Integer, Integer>> map;
    private int capacity;
    
    public LRU_Cache(int capacity) {
        this.capacity = capacity;
        this.head = null;
        map = new HashMap<Integer, Entry<Integer, Integer>>();
    }
    
    public int get(int key) {
        Entry<Integer, Integer> entry = map.get(key);
        if (null == entry) {
            return -1;
        } else {
            Integer value = entry.value;
            moveToHead(entry);
            return value;
        }
    }
    
    public void set(int key, int value) {
        Entry<Integer, Integer> entry = map.get(key);
        if (null == entry) {
            if (map.size() == capacity) {
                // remove the last
                Entry<Integer, Integer> expire = removeTail();
                map.remove(expire.key);
            }
            
            entry = new Entry<Integer, Integer>(key, value);
            addToHead(entry);
            map.put(key, entry);
        } else {
            entry.value = value;
            moveToHead(entry);
        }
    }
    
    private void addToHead(Entry<Integer, Integer> entry) {
        if (null == head) {
            head = entry;
            head.next = head;
            head.priv = head;
        } else {
            entry.next = head;
            entry.priv = head.priv;
            head.priv.next = entry;
            
            head.priv = entry;
            head = entry;
        }
    }
    
    private void moveToHead(Entry<Integer, Integer> entry) {
        if (entry == head) {
            return;
        }
        
        Entry<Integer, Integer> priv = entry.priv;
        Entry<Integer, Integer> next = entry.next;
        
        priv.next = next;
        next.priv = priv;
        
        entry.next = head;
        entry.priv = head.priv;
        head.priv.next = entry;
        
        head.priv = entry;
        head = entry;
    }
    
    private Entry<Integer, Integer> removeTail() {
        if (head.priv == head) {
            Entry<Integer, Integer> p = head;
            head = null;
            
            return p;
        }
        
        Entry<Integer, Integer> tail = head.priv;
        Entry<Integer, Integer> priv = tail.priv;
        Entry<Integer, Integer> next = tail.next;
        
        priv.next = tail.next;
        next.priv = priv;
        
        tail.next = null;
        tail.priv = null;

        return tail;
    }
}
