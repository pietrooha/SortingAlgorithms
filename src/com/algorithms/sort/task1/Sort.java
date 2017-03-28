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
        comparisons = 0;
        swaps = 0;
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

    public void insertionSort(int[] sequence, int start, int end)
    {
        //System.out.println(java.util.Arrays.toString(sequence));
        for(int i = start + 1; i < end; i++)
        {
            int j = i;
            comparisons++;
            while (j > 0 && sequence[j] < sequence[j - 1])
            {
                comparisons++;
                swaps++;
                int temp = sequence[j];
                sequence[j] = sequence[j - 1];
                sequence[j - 1] = temp;

                j--;
                //System.out.println(java.util.Arrays.toString(sequence));
            }
        }
    }

    public int partition(int[] list, int leftIndex, int rightIndex)
    {
        int left = leftIndex;
        int right = rightIndex;
        int pivot = list[leftIndex];

        while (left < right)
        {
            comparisons++;
            if (list[left] < pivot)
            {
                left++;
                continue;
            }
            comparisons++;
            if (list[right] > pivot)
            {
                right--;
                continue;
            }
            swaps++;
            int tmp = list[left];
            list[left] = list[right];
            list[right] = tmp;
            left++;
        }

        return left;
    }

    public void calculateStatistics()
    {
        int currentSize = 100;

        while(currentSize <= size)
        {
            long sumOfComp = 0;
            long sumOfSwaps = 0;

            int numberOfRepeat = 10;
            for (int i = 0; i < numberOfRepeat; i++)
            {
                sequence = createSequence(currentSize);
                reverseSequence();
                runSort();
                sumOfComp += comparisons;
                sumOfSwaps += swaps;
            }
            comparisons = sumOfComp / numberOfRepeat;
            swaps = sumOfSwaps / numberOfRepeat;
            System.out.println(currentSize + " " + comparisons + " " + swaps);
            currentSize += 100;
        }
    }
}