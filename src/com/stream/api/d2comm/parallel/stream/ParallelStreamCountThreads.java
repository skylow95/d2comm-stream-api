package com.stream.api.d2comm.parallel.stream;

import java.util.concurrent.ForkJoinPool;

public class ParallelStreamCountThreads {

    public static void main(String[] args) {
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println(commonPool.getParallelism());
    }

}
