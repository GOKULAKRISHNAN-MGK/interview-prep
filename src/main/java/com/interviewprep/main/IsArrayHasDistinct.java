package com.interviewprep.main;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IsArrayHasDistinct {
    public static void main(String[] args) {
        String[] arr = {"a", "b", "c", "b", "c", "d"};
        int k = 2;
        List<String> distinct = Arrays.stream(arr)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(f->f.getValue()==1)
                .map(Map.Entry::getKey)
                .toList();

        if(distinct.size() == k) {
            distinct.forEach(System.out::println);
        } else {
            System.out.println("Invalid");
        }
    }
}
