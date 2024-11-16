package com.interviewprep.main;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OldToNewCode {
    public static void main(String[] args) {
        //Iterating Over a List
        List<String> names= new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        iterateList(names);

        //Filtering a List
        names.add("August");
        names.add("David");
        filterList(names);

        //Sorting a List
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(7);
        numbers.add(1);
        numbers.add(0);
        sortList(numbers);

        //Length of names in a new List
        lengthOfNames(names);

        //Map to a List of names
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Alice");
        map.put(2, "Bob");
        map.put(3, "Charlie");
        mapToList(map);

        //Remove Duplicates
        numbers.add(5);
        numbers.add(7);
        removeDuplicates(numbers);

        //Counting Elements
        names.add("August");
        names.add("David");
        countingNames(names);

        groupingElements(names);
    }

    private static void groupingElements(List<String> names) {
        //Stream to get the stream of values, collect to collecting them grouping by for map and giving identity and count as members and foreach for printing
        System.out.println("grouping names from the List of Names: ");
        names.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().forEach(System.out::println);
        System.out.println("---------------------------");
    }

    private static void countingNames(List<String> names) {
        //Stream to get the stream of values, collect to collecting them grouping by for map and giving identity and count as members and foreach for printing
        System.out.println("counting August from the List of Names: ");
        System.out.println(names.stream().filter(str -> str.equals("August")).count());
        System.out.println("---------------------------");
    }

    private static void removeDuplicates(List<Integer> numbers) {
        //Stream to get the stream of values, distinct for getting unique values and forEach and Method Reference for printing
        System.out.println("remove duplicates from the List of Numbers: ");
        numbers.stream().distinct().forEach(System.out::println);
        System.out.println("---------------------------");
    }

    private static void mapToList(Map<Integer, String> map) {
        //get the values from the map and stream to the get the stream of values and toList to convert it to list and forEach and Method Reference for printing
        System.out.println("List of names from the map of names");
        map.values().stream().toList().forEach(System.out::println);
        System.out.println("---------------------------");
    }

    private static void lengthOfNames(List<String> names) {
        //Stream to get the stream of values, mapToInt with method reference to change the value of string to integer of length of string
        // and forEach and Method Reference for printing
        System.out.println("Length of names from the List of Names: ");
        names.stream().mapToInt(String::length).forEach(System.out::println);
        System.out.println("---------------------------");
    }

    private static void sortList(List<Integer> numbers) {
        //Stream to get the stream of values, sorted for sorting and forEach and Method Reference for printing
        System.out.println("Sort a List of Numbers: ");
        numbers.stream().sorted().forEach(System.out::println);
        System.out.println("---------------------------");
    }

    private static void filterList(List<String> names) {
        //Stream to get the stream of values, filter to filter the condition, for each to iterate to filtered list and method reference for printing
        System.out.println("Filter a List of Names: ");
        names.stream().filter(str->str.startsWith("A")).forEach(System.out::println);
        System.out.println("---------------------------");
    }

    private static void iterateList(List<String> names) {
        //Iterate Using forEach and Method Reference for printing
        System.out.println("Iterate a List of Names: ");
        names.forEach(System.out::println);
        System.out.println("---------------------------");
    }
}
