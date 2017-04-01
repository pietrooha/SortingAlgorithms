package com.algorithms.sort.task1;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.Random;

/**
 * Created by piotr on 20.03.17.
 */
public abstract class Sort
{
    protected long comparisons;
    protected long swaps;
    protected boolean isSorted;
    protected int size;
    protected int[] sequence;

    public Sort(boolean isSorted, int size)
    {
        this.isSorted = isSorted;
        this.size = size;
    }

    abstract void runSort();

    public long getComparisons()
    {
        return comparisons;
    }

    public long getSwaps()
    {
        return swaps;
    }

    public boolean getIsSorted()
    {
        return isSorted;
    }

    public int getSize()
    {
        return size;
    }

    public int[] getSequence()
    {
        return sequence;
    }

    public int[] createSequence(int size)
    {
        Random randomGenerator = new Random();
        sequence = new int[size];
        int x = size * 5;

        for(int i = 0; i < size; i++)
        {
            if(isSorted == false)
            {
                sequence[i] = randomGenerator.nextInt(size * 2);
            }
            else
            {
                sequence[i] = x;
                int randomNumber = randomGenerator.nextInt(10);
                x -= randomNumber;
            }
        }

        return sequence;
    }

    public void reverseSequence()
    {
        int left = 0;
        int right = sequence.length - 1;

        while( left < right )
        {
            int temp = sequence[left];
            sequence[left] = sequence[right];
            sequence[right] = temp;

            left++;
            right--;
        }
    }

    public void insertionSort(int[] arr, int start, int end)
    {
        //System.out.println(java.util.Arrays.toString(sequence));
        for(int i = start + 1; i < end; i++)
        {
            int j = i;
            comparisons++;
            while (j > 0 && arr[j] < arr[j - 1])
            {
                comparisons++;
                swaps++;
                swap(arr, j, j - 1);

                j--;
                //System.out.println(java.util.Arrays.toString(sequence));
            }
        }
    }

    public int[] mergeSort(int[] arr)
    {
        int size = arr.length;
//*        System.out.println(java.util.Arrays.toString(inputSequence));

        if(size > 1)
        {
            int mid = size / 2;
            int leftSize = mid;
            int rightSize = size - mid;
            int[] left = new int[leftSize];
            int[] right = new int[rightSize];

            for (int i = 0; i < mid; i++)
            {
                left[i] = arr[i];
            }
            for (int i = mid; i < size; i++)
            {
                right[i - mid] = arr[i];
            }
            //*        System.out.println(java.util.Arrays.toString(left));
            //*        System.out.println(java.util.Arrays.toString(right));
            left = mergeSort(left);
            right = mergeSort(right);
            merge(left, right, arr);
        }

        return arr;
    }

    public void merge(int[] left, int[] right, int[] arr)
    {
        int leftSize = left.length;
        int rightSize = right.length;

        int i = 0, j = 0, k = 0;
        while(leftSize != j && rightSize != k)
        {
            comparisons++;
            if(left[j] < right[k])
            {
                arr[i] = left[j];
                i++;
                j++;
            }
            else
            {
                arr[i] = right[k];
                i++;
                k++;
                swaps++;
            }
        }

        while(leftSize != j)
        {
            arr[i] = left[j];
            i++;
            j++;
        }

        while(rightSize != k)
        {
            arr[i] = right[k];
            i++;
            k++;
        }
    }

    public int partition(int[] arr, int left, int right)
    {
        int pivotIdx = (left + right) / 2;
        int pivot = arr[pivotIdx];

        swap(arr, pivotIdx, right);
        int actualPosition = left;

        for (int i = left; i <= right - 1; i++)
        {
            comparisons++;
            if (arr[i] <= pivot)
            {
                swap(arr, i, actualPosition);
                swaps++;
                actualPosition++;
            }
        }
        //System.out.println(java.util.Arrays.toString(list));
        swap(arr, actualPosition, right);

        return actualPosition;
    }

    public void swap(int[] array, int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        //swaps++;
    }

    public void calculateStatistics()
    {
        int currentSize = 100;

        while(currentSize <= size)
        {
            long sumOfComp = 0;
            long sumOfSwaps = 0;

            int numberOfRepeat = 15;
            for (int i = 0; i < numberOfRepeat; i++)
            {
                comparisons = 0;
                swaps = 0;
                sequence = createSequence(currentSize);
                //reverseSequence();
                try
                {
                    runSort();
                }
                catch(AssertionError assErr)
                {
                    System.out.println("Error");
                }

                sumOfComp += comparisons;
                sumOfSwaps += swaps;
            }
            /* Average numbers of comparisons and swaps */
            comparisons = sumOfComp / numberOfRepeat;
            swaps = sumOfSwaps / numberOfRepeat;
            System.out.println(currentSize + " " + comparisons + " " + swaps);
            currentSize += 100;
        }
    }
}