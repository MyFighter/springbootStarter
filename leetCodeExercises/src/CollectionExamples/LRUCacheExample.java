package CollectionExamples;

import sun.misc.LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheExample {

    public static void main(String[] args) {
        LRUCache2<Integer, String> cache = new LRUCache2<>();
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");
        cache.get(1);
        cache.put(4, "d");
        cache.get(3);
        cache.put(5, "e");
        cache.put(6, "f");
        System.out.println(cache.keySet());

        LinkedHashMap<Integer, String> li = new LinkedHashMap<>();
        li.put(1, "1");
        li.put(2, "2");
        li.put(3, "3");
        li.put(4, "4");
        li.put(5, "5");

        System.out.println(li.keySet());
    }
}

class LRUCache2<K, V> extends LinkedHashMap<K, V>{
    private static final int MAX_ENTRIES = 3;
    protected boolean removeEldestEntry(Map.Entry eldest){
        return size() > MAX_ENTRIES;
    }

    LRUCache2(){
        super(MAX_ENTRIES, 0.75f, true);
    }
}
