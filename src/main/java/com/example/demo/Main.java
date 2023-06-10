package com.example.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> items = stream.sorted(order).collect(Collectors.toList());
        if (!items.isEmpty()) {
            minMaxConsumer.accept(items.get(0), items.get(items.size() - 1));
        } else {
            minMaxConsumer.accept(null, null);
        }
    }

    public static long findCount(List<Integer> list) {
        return list.stream()
                .filter(x -> x % 2 == 0)
                .count();

    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(12, 15, 36, 48, 16, 17, 18, 22, 25));
        Stream<Integer> list1 = list.stream();

        System.out.println(findCount(list));
        findMinMax(list1, Integer::compareTo, (x, y) -> System.out.printf("min: " + x + " max: " + y));
        list1.close();

    }
}