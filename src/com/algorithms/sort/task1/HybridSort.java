package com.algorithms.sort.task1;

/**
 * Created by piotr on 28.03.17.
 */
public class HybridSort extends Sort
{
    public HybridSort(boolean isSorted, int size)
    {
        super(isSorted, size);
    }

    public void runSort()
    {
        int start = 0;
        int end = sequence.length - 1;

        sort(sequence, start, end);
//        System.out.println(java.util.Arrays.toString(sequence));
    }

    public void sort(int[] list, int start, int end)
    {
        if(start < end)
        {
            if((end - start) < 9)
            {
                insertionSort(list, start, end + 1);
            }
            else
            {
                int part = partition(list, start, end);
                sort(list, start, part - 1);
                sort(list, part + 1, end);
            }
        }
    }

    public static void main(String[] args)
    {
        HybridSort hbrdSort = new HybridSort(false, 10000);
        hbrdSort.calculateStatistics();
     }
}