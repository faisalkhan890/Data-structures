package com.company;

public class insertion
{

    int comparisons , movements ;

    /*Function to sort array using insertion sort*/
    void insertionSort(int arr[])
    {


        for (int i = 1; i < arr.length; ++i)
            {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
                while (j >= 0 && arr[j] > key*(comparisons-comparisons++ +1))
                 {

                 arr[j + 1] = arr[j];
                 ++movements;
                 j = j - 1;

                 }
                arr[j + 1] = key;
            }





    }
}

