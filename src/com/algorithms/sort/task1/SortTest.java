package com.algorithms.sort.task1;

/**
 * Created by piotr on 28.03.17.
 */
public class SortTest
{
    public static void main(String[] args)
    {
        boolean isSorted = false;
        int size = 10000;
        long start = 0;
        long stop = 0;

        InsertionSort insrtSort = new InsertionSort(isSorted, size);
        start = System.currentTimeMillis();
        insrtSort.calculateStatistics();
        stop = System.currentTimeMillis();
        System.out.println("InsertionSort execution time: "+(stop-start));
        insrtSort = null;
        start = stop = 0;

        MergeSort mergeSort = new MergeSort(isSorted, size);
        start = System.currentTimeMillis();
        mergeSort.calculateStatistics();
        stop = System.currentTimeMillis();
        System.out.println("MergeSort execution time: "+(stop-start));
        mergeSort = null;
        start = stop = 0;

        QuickSort quickSort = new QuickSort(isSorted, size);
        start = System.currentTimeMillis();
        quickSort.calculateStatistics();
        stop = System.currentTimeMillis();
        System.out.println("QuickSort execution time: "+(stop-start));
        quickSort = null;
        start = stop = 0;

        HybridSort hbrdSort = new HybridSort(isSorted, size);
        start = System.currentTimeMillis();
        hbrdSort.calculateStatistics();
        stop = System.currentTimeMillis();
        System.out.println("HybridSort execution time: "+(stop-start));
        hbrdSort = null;
        start = stop = 0;

        QuickSortDualPivot quickDualPivSort = new QuickSortDualPivot(isSorted, size);
        start = System.currentTimeMillis();
        quickDualPivSort.calculateStatistics();
        stop = System.currentTimeMillis();
        System.out.println("QuickSortDualPivot execution time: "+(stop-start));
        hbrdSort = null;
        start = stop = 0;
    }
}