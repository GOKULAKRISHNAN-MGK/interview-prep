package com.interviewprep.main;

import java.util.*;
import java.util.stream.Collectors;

 public class CollectionPrepMain {
    public static void main(String[] args) {
        Map<UUID, String> hashMap = new HashMap<>();
        Map<UUID, String> linkedHashMap = new LinkedHashMap<>();
        TreeMap<UUID, String> treeMap = new TreeMap<UUID, String>(comparator);

        String string = "Test the knowledge from basic";

        List<String> strings = Arrays.stream(string.split(" ")).toList();
        strings.forEach(s->{
            hashMap.put(UUID.randomUUID(), s);
            linkedHashMap.put(UUID.randomUUID(), s);
            treeMap.put(UUID.randomUUID(), s);
        });
        System.out.println("HashMap: ");
        hashMap.entrySet().forEach(System.out::println);
        System.out.println("LinkedHashMap: ");
        linkedHashMap.entrySet().forEach(System.out::println);
        System.out.println("TreeMap: ");
        treeMap.entrySet().forEach(System.out::println);
    }
}