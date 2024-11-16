package com.interviewprep.main;

import java.util.concurrent.CompletableFuture;

public class AsyncPrep {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->{
            return 42;
        });

        future.thenApply(result->result*2)
                .thenAccept(finalResult->System.out.println("Result: "+finalResult));

        future.join();
    }
}
