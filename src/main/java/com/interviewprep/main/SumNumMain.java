package com.interviewprep.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SumNumMain {
    public static void main(String[] args) {
        int[] nmbrs = {1, 3, 5, 8, 11, 15, 4, 2};
        int sum = 16;

        int[] pairs = printPairs(nmbrs, sum);
        System.out.println("Position of Pairs: "+Arrays.toString(pairs));
        System.out.println("Pairs: ");
        for(int i: pairs) {
            System.out.print(nmbrs[i]+" ");
        }
        System.out.println("\nMultiple Pairs: ");
        printPairsMultiple(nmbrs, sum).forEach((key, value) -> System.out.println("[" + key + ", " + value + "] "));

        System.out.println("Triplet Sum: ");
        printTripletSum(nmbrs, sum).forEach(s -> {
            s.forEach(a->System.out.print(a+" "));
            System.out.println("\n-------------");
        });

        System.out.println("Four Sum: ");
        printFourSum(nmbrs, sum).forEach(s -> {
            s.forEach(a->System.out.print(a+" "));
            System.out.println("\n-------------");
        });

        System.out.println("Five Sum: ");
        printFiveSum(nmbrs, sum).forEach(s -> {
            s.forEach(a->System.out.print(a+" "));
            System.out.println("\n-------------");
        });

    }

    private static HashMap<Integer, Integer> printPairsMultiple(int[] nmbrs, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < nmbrs.length; i++) {
            int cmplmnt = sum - nmbrs[i];
            if (map.containsKey(cmplmnt)) {
                result.put(nmbrs[i], cmplmnt);
            }
            map.put(nmbrs[i], i);
        }
        return result;
    }

    private static int[] printPairs(int[] nmbrs, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nmbrs.length;i++) {
            int cmplmnt = sum - nmbrs[i];
            if(map.containsKey(cmplmnt)) {
                return new int[] {map.get(cmplmnt), i};
            }
            map.put(nmbrs[i], i);
        }
        return new int[] {};
    }

    private static List<List<Integer>> printTripletSum(int[] nmbrs, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nmbrs);
        for(int i = 0; i<nmbrs.length-2; i++) {
            if(i>0 && nmbrs[i] == nmbrs[i-1]) {
                continue;
            } 
            int newTarget = sum - nmbrs[i];
            int left = i+1;
            int right = nmbrs.length-1;

            while (left < right) {
                int value = nmbrs[left]+nmbrs[right];
                if(value == newTarget) {
                    result.add(Arrays.asList(nmbrs[i],nmbrs[left],nmbrs[right]));
                    while(left < right && nmbrs[left] == nmbrs[left+1]) {
                        left++;
                    }
                    while (left < right && nmbrs[right] == nmbrs[right-1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
                else if(value < newTarget ) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }

        return result;
    }

    private static List<List<Integer>> printFourSum(int[] nmbrs, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nmbrs);
        for (int j  = 0; j<nmbrs.length-3; j++) {
            if(j>0 && nmbrs[j] == nmbrs[j-1]) {
                continue;
            }

            for(int i = 0; i<nmbrs.length-2; i++) {
                if(i>j+1 && nmbrs[i] == nmbrs[i-1]) {
                    continue;
                }
                int newTarget = sum - nmbrs[i] - nmbrs[j];
                int left = i+1;
                int right = nmbrs.length-1;

                while (left < right) {
                    int value = nmbrs[left]+nmbrs[right];
                    if(value == newTarget) {
                        result.add(Arrays.asList(nmbrs[j],nmbrs[i],nmbrs[left],nmbrs[right]));
                        while(left < right && nmbrs[left] == nmbrs[left+1]) {
                            left++;
                        }
                        while (left < right && nmbrs[right] == nmbrs[right-1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                    else if(value < newTarget ) {
                        left++;
                    }
                    else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    private static List<List<Integer>> printFiveSum(int[] nmbrs, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nmbrs);
        for (int i = 0; i< nmbrs.length-4; i++) {
            if(i>0 && nmbrs[i] == nmbrs[i-1]) {
                continue;
            }
            for (int j=0; j< nmbrs.length-3; j++) {
                if (j>i+1 && nmbrs[j] == nmbrs[j-1]) {
                    continue;
                }
                for (int k=0; k<nmbrs.length-2; k++) {
                    if (k>j+1 && nmbrs[k] == nmbrs[k-1]) {
                        continue;
                    }
                    int newTarget = sum - nmbrs[i] - nmbrs[j] - nmbrs[k];
                    int left = k+1;
                    int right = nmbrs.length-1;

                    while (left < right) {
                        int value = nmbrs[left]+nmbrs[right];
                        if (value == newTarget) {
                            result.add(Arrays.asList(nmbrs[i],nmbrs[j],nmbrs[k],nmbrs[left],nmbrs[right]));
                            while (left<right && nmbrs[left] == nmbrs[left+1]) {
                                left++;
                            }
                            while (left<right && nmbrs[right] == nmbrs[right-1]) {
                                right--;
                            }
                            left++;
                            right--;
                        } else if (value < newTarget) {
                            left++;
                        } else {
                            right--;
                        }
                    }
                }
            }
        }
        return result;
    }
}
