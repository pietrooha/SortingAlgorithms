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

    public void mergeSort(int[] inputSequence)
    {
        int size = inputSequence.length;
//*        System.out.println(java.util.Arrays.toString(inputSequence));

        if (size < 2)
            return;

        int mid = size / 2;
        int leftSize = mid;
        int rightSize = size - mid;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        for (int i = 0; i < mid; i++)
        {
            left[i] = inputSequence[i];
        }
        for (int i = mid; i < size; i++)
        {
            right[i - mid] = inputSequence[i];
        }
//*        System.out.println(java.util.Arrays.toString(left));
//*        System.out.println(java.util.Arrays.toString(right));
        mergeSort(left);
        mergeSort(right);
        merge(left, right, inputSequence);
    }

    public void merge(int[] left, int[] right, int[] arr)
    {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize)
        {
            comparisons++;
            if (left[i] <= right[j])
            {
                arr[k] = left[i];
                i++;
                k++;
            }
            else
            {
                arr[k] = right[j];
                k++;
                j++;
                swaps++;
            }
        }

        while (i < leftSize)
        {
            arr[k] = left[i];
            k++;
            i++;
        }

        while (j < leftSize)
        {
            arr[k] = right[j];
            k++;
            j++;
        }
    }

    public static void main(String[] args)
    {
        MergeSort mergeSort = new MergeSort(false, 10000);
        mergeSort.calculateStatistics();
    }
}