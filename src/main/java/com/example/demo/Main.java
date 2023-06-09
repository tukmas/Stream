package com.example.demo;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Random random = new Random();
        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            integerList.add(i, random.nextInt(100));
        }
        System.out.println(integerList);
        Optional<Integer> max = integerList.stream().max(Comparator.naturalOrder());
        Optional<Integer> min = integerList.stream().min(Comparator.naturalOrder());
        System.out.println("Максимальное число - " + max + "\n Минимальное число - " + min);
        main.findEvenNumbersInList(integerList);

    }
    private <T> void findMinMax(Stream<? extends T> stream,
                                Comparator<? super T> order,
                                BiConsumer<? super T, ? super T> minMaxConsumer) {

    }
    private void findEvenNumbersInList(List<Integer> integerList){
        integerList.stream().filter(integer -> integer % 2 == 0).sorted().forEach(System.out::println);
    }
}