package com.interviewprep.main;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TestFuncInterface {
    public static void main(String[] args) {
        StringManipulation strMod = (str)-> String.join("", str.toUpperCase().split(" "));

        String input = "Test the Value";
        System.out.println(strMod.stringMod(input));
    }
}
