import sun.misc.LRUCache;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Test {


    public static void main(String[] args) {
        List<String> sbs = new ArrayList<>();
        String s = "";
        s += "2";
        sbs.add(s);
        s += "3";
        System.out.println(sbs.get(0));
    }
}
