package com.algorithms.sort.task1;

/**
 * Created by piotr on 20.03.17.
 */
public class InsertionSort extends Sort
{
    public InsertionSort(boolean isSorted, int size)
    {
        super(isSorted, size);
    }

    public void runSort()
    {
        insertionSort(sequence, 0, sequence.length);
    }

    public static void main(String[] args)
    {
        InsertionSort insrtSort = new InsertionSort(false, 10000);
        insrtSort.calculateStatistics();
    }
}