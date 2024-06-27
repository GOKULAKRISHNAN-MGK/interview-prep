package com.interviewprep.main;

import java.util.HashMap;

public class SubArrayMain {
    public static void main(String[] args) {
        int[] nmbrs = {1,1,1};
        int k = 2;
        System.out.println("Count of SubArray that adds up to "+k+" : "+sumOfSubArray(nmbrs, k));

        int[] nmbrs1 = {1,2,3,5,8};
        int k1 = 5;
        System.out.println("Count of SubArray that adds up to "+k1+" : "+sumOfSubArray(nmbrs1, k1));
    }

    private static int sumOfSubArray(int[] nmbrs, int k) {
        HashMap<Integer, Integer> concurrentSumMap = new HashMap<>();
        concurrentSumMap.put(0,1);
        int concurrentSum = 0;
        int count = 0;
        for (int num: nmbrs) {
            concurrentSum+=num;
            if(concurrentSumMap.containsKey(concurrentSum-k)) {
                count+=concurrentSumMap.get(concurrentSum-k);
            }
            concurrentSumMap.put(concurrentSum,concurrentSumMap.getOrDefault(concurrentSum, 0)+1);
        }
        return count;
    }
}
