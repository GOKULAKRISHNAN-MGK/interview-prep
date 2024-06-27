package com.interviewprep.main;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrepMain {
    public static void main(String[] args) {
        List<Integer> integersOddEven = Arrays.asList(1, 65, 32, 44, 89, 133, 453, 456);
        List<Integer> integersDplcts = Arrays.asList(65, 65, 44, 44, 89, 133, 453, 453);
        Set<Integer> integerSet = new HashSet<>(integersDplcts);
        System.out.println("Printing the Set: ");
        integerSet.forEach(System.out::println);
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("Power of Things","1st value");
        stringMap.put("Popular People being bad","1st value 2nd try");
        stringMap.put("Politically Incorrect Statement","real first value");
        System.out.println("HashMap:");
        printStrngMap(stringMap);
        Map<Long, String> map = new HashMap<>();
        map.put(1L,"1st value");
        map.put(4L,"1st value 2nd try");
        map.put(3L,"real first value");
        System.out.println("HashMap:");
        printMap(map);
        Map<Long, String> linkedMap = new LinkedHashMap<>();
        linkedMap.put(1L,"1st value");
        linkedMap.put(4L,"1st value 2nd try");
        linkedMap.put(3L,"real first value");
        System.out.println("LinkedHashMap:");
        printMap(linkedMap);
        System.out.println("Even and Odd Numbers List: "+integersOddEven);
        getEvenOddNumbers(integersOddEven);
        System.out.println("List with Duplicate Numbers: "+integersDplcts);
        getDistinctNumbers(integersDplcts);
        String freq= "Test the power of enemy to win";
        System.out.println("Frequency String: "+freq);
        getFrequencyChar(freq);
        getSecondBigNumber(integersOddEven);
        List<String> stringList = Arrays.asList("ChatGPT", "Gemini", "Copilot", "Adobe Firefly");
        addDelimString(stringList);
        int SummingNum = 312349;
        getSumOfNum(SummingNum);
    }

    private static void printStrngMap(Map<String, String> stringMap) {
        stringMap.entrySet().forEach(System.out::println);
    }

    private static void printMap(Map<Long, String> map) {
        map.entrySet().forEach(System.out::println);
    }

    private static void getSumOfNum(int summingNum) {
        System.out.println("Summation of digits of "+summingNum+" is "+ Stream.of(String.valueOf(summingNum).split("")).mapToInt(Integer::parseInt).sum());
    }

    private static void addDelimString(List<String> stringList) {
        System.out.println("Joined String from the List : "+stringList.stream().collect(Collectors.joining(",", "[","]")));
    }

    private static void getSecondBigNumber(List<Integer> integersOddEven) {
        Optional<Integer> secondBigNum = Optional.of(integersOddEven.stream()
                .sorted(Comparator.reverseOrder()).skip(1).findFirst().get());
        System.out.println("Second Big Number : "+secondBigNum);
    }

    private static void getDistinctNumbers(List<Integer> integersDplcts) {
        System.out.println("Distinct Numbers in the List:");
        integersDplcts.stream().distinct().forEach(System.out::println);
        System.out.println("Distinct Numbers using Set");
        new TreeSet<>(integersDplcts).forEach(System.out::println);
    }

    private static void getEvenOddNumbers(List<Integer> integers) {
        List<Integer> integerEvenList = integers.stream()
                .filter(i->i%2==0).toList();
        List<Integer> integerOddList = integers.stream()
                .filter(i->i%2==0).toList();
        System.out.println("Even Numbers:");
        integerEvenList.forEach(System.out::println);
        System.out.println("Odd Numbers:");
        integerOddList.forEach(System.out::println);
    }

    private static void getFrequencyChar(String freq) {
        Map<Character, Long> stringLongMap = freq.chars()
                .mapToObj(c->(char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        stringLongMap.entrySet().forEach(System.out::println);
    }
}
