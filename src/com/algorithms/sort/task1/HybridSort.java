package com.algorithms.sort.task1;

import static com.algorithms.sort.task1.HybridVersion.MergeSortAndInsertionSort;
import static com.algorithms.sort.task1.HybridVersion.QuickSortAndInserionSort;

/**
 * Created by piotr on 28.03.17.
 */
public class HybridSort extends Sort
{
    private HybridVersion hybrV;

    public HybridSort(boolean isSorted, int size, HybridVersion hybrV)
    {
        super(isSorted, size);
        this.hybrV = hybrV;
    }

    public void runSort()
    {
        int start = 0;
        int end = sequence.length - 1;

        switch (hybrV)
        {
            case QuickSortAndInserionSort:
                betterQuickSort(sequence, start, end);
                //System.out.println(java.util.Arrays.toString(sequence));
                break;
            case MergeSortAndInsertionSort:
                betterMergeSort(sequence, start, end);
                break;
            default:
                throw new AssertionError("Unknown Hybrid Version Algorithm" + hybrV);
        }
    }

    /** QuickSort with InsertionSort */
    public void betterQuickSort(int[] list, int start, int end)
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
                betterQuickSort(list, start, part - 1);
                betterQuickSort(list, part + 1, end);
            }
        }
    }

    /** MergeSort with InsertionSort */
    public void betterMergeSort(int[] arr, int start, int end)
    {
        if ((end - start) <= 10)
            insertionSort(arr, start, end);
        else
        {
            mergeSort(arr);
        }
    }

    public static void main(String[] args)
    {
        HybridSort hbrdSort = new HybridSort(true, 40000, QuickSortAndInserionSort);
        hbrdSort.calculateStatistics();
        //System.out.println(java.util.Arrays.toString(hbrdSort.sequence));
     }
}