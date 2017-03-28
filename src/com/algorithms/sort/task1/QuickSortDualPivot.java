package com.algorithms.sort.task1;

/**
 * Created by piotr on 28.03.17.
 */
public class QuickSortDualPivot extends Sort
{
    public QuickSortDualPivot(boolean isSorted, int size)
    {
        super(isSorted, size);
    }

    public void runSort()
    {
        //System.out.println(java.util.Arrays.toString(sequence));
        int start = 0;
        int end = sequence.length - 1;

        dualPivot(sequence, start, end);
        //System.out.println(java.util.Arrays.toString(sequence));
    }

    public void goTrivial(int[] ar, int start, int end)
    {
        comparisons++;
        if(ar[start] > ar[start + 1])
            swap(ar, start, start + 1);

        comparisons++;
        if(ar[start + 1] > ar[end])
            swap(ar, start + 1, end);

        comparisons++;
        if(ar[start] > ar[start + 1])
            swap(ar, start, start + 1);
    }

    public void swap(int[] ar, int i, int j)
    {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
        swaps++;
    }

    public boolean isSorted(int[] ar, int start, int end)
    {
        if(start >= end)
            return true;

        for(int i = start + 1; i <= end; i++)
        {
            comparisons++;
            if(ar[i] < ar[i - 1])
                return false;
        }

        return true;
    }


    public void dualPivot(int[] ar, int start, int end)
    {
        if(start >= end || isSorted(ar, start, end))
            return;

        if(end - start < 3)
        {
            goTrivial(ar, start, end);
            return;
        }

        int lt = start + 1, i = start + 1, gt = end - 1;
        while(i <= gt)
        {
            comparisons++;
            if (ar[i] < ar[start])
            {
                swap(ar, i, lt);
                i++;
                lt++;
            }
            else if (ar[i] > ar[end])
            {
                comparisons++;
                swap(ar, i, gt);
                gt--;
            }
            else
            {
                comparisons++;
                i++;
            }
        }
        lt--;
        swap(ar, start, lt);
        gt++;
        swap(ar, gt, end);

        dualPivot(ar, start, lt - 1);
        dualPivot(ar, gt + 1, end);
        dualPivot(ar, lt + 1, gt - 1);
    }

    public static void main(String[] args)
    {
        QuickSortDualPivot quickSortDualPivot = new QuickSortDualPivot(false, 100000);
        quickSortDualPivot.calculateStatistics();
    }
}