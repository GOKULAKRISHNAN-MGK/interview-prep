package com.interviewprep.main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongConsecutiveSequence {
    public static void main(String[] args) {
        int[] nmbrs = {1, 5, 3, 2, 4, 100, 99, 97, 98, 5};
        System.out.println("Longest Consecutive Streak of "+ Arrays.toString(nmbrs) +" is "+findLongConsecStreak(nmbrs));
    }

    private static int findLongConsecStreak(int[] nmbrs) {
        Set<Integer> numSet = new HashSet<>();
        int longestStreak = 0;
        for (int num: nmbrs) {
            numSet.add(num);
        }
        for (int num: numSet) {
            if(!numSet.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (numSet.contains(currentNum+1)) {
                    currentNum+=1;
                    currentStreak+=1;
                }
                longestStreak=Math.max(longestStreak,currentStreak);
            }
        }
        return longestStreak;
    }
}
