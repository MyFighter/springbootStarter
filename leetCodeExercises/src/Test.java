import sun.misc.LRUCache;

import javax.swing.*;
import java.util.Arrays;
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
    }
}
