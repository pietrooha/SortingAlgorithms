package com.algorithms.sort.task1;

import java.util.Comparator;

/**
 * Created by piotr on 20.03.17.
 */
public class MergeSort extends Sort
{
    public MergeSort(boolean isSorted, int size)
    {
        super(isSorted, size);
    }

    public void runSort()
    {
        mergeSort(sequence);
    }

    public static void main(String[] args)
    {
        MergeSort mergeSort = new MergeSort(false, 10000);
        mergeSort.calculateStatistics();
        //System.out.println(java.util.Arrays.toString(mergeSort.sequence));
    }
}