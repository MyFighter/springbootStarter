import sun.misc.LRUCache;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Test {


    public static void main(String[] args) {
        ConcurrentMap<Integer, Long> collect = Arrays.asList("3232", "faefe", "ffggg", "qerett", "ffe")
                .parallelStream()
                .collect(Collectors.groupingByConcurrent(String::length, Collectors.counting()));

        System.out.println(collect);

        ConcurrentMap<Integer, List<String>> collect1 = Arrays.asList("3232", "faefe", "ffggg", "qerett", "ffe")
                .parallelStream()
                .collect(Collectors.groupingByConcurrent(String::length));
        System.out.println(collect1);

        LinkedList<Integer> linkedList = new LinkedList<>();
        List<Integer> arr = new ArrayList<>();
        long c = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            linkedList.add(i++);
        }
        System.out.println("linkedlist" + (System.currentTimeMillis() - c));
        long c2 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            arr.add(i++);
        }
        System.out.println("arr" + (System.currentTimeMillis() - c2));
    }

}
