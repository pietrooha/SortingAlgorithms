package com.algorithms.sort.task1;

/**
 * Created by piotr on 20.03.17.
 */
public class QuickSort extends Sort
{
    public QuickSort(boolean isSorted, int size)
    {
        super(isSorted, size);
    }

    public void runSort()
    {
        //System.out.println(java.util.Arrays.toString(sequence));
        int start = 0;
        int end = sequence.length - 1;

        quickSort(sequence, start, end);
        //System.out.println(java.util.Arrays.toString(sequence));
    }

    public int[] quickSort(int[] sequence, int start, int end)
    {
        if(start < end)
        {
            int pivot;
            pivot = partition(sequence, start, end);
            quickSort(sequence, start, pivot - 1);
            quickSort(sequence, pivot + 1, end);
        }
//        System.out.println(java.util.Arrays.toString(sequence));

        return  sequence;
    }

    public static void main(String[] args)
    {
        QuickSort quickSort = new QuickSort(false, 10000);
        quickSort.calculateStatistics();
    }
}