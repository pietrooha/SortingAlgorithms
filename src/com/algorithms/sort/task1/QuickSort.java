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

    public int[] quickSort(int[] sequence, int left, int right)
    {
        if(left < right)
        {
            int position = partition(sequence, left, right);
            quickSort(sequence, left, position - 1);
            quickSort(sequence, position + 1, right);
        }

        return sequence;
    }

    public static void main(String[] args)
    {
        QuickSort quickSort = new QuickSort(false, 1000);
        quickSort.calculateStatistics();
        //System.out.println(java.util.Arrays.toString(quickSort.sequence));
    }
}