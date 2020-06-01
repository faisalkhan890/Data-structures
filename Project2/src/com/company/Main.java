package com.company;
import java.util.Scanner;
import java.io.*;



public class Main {



    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        boolean repeat= true;
        long winningTime=1000000000;
        String winningSort = "";

        long totalTime=0, endTime=0, startTime=0;

        // loop the whole program
       do {
           System.out.println("Enter size of array: ");
           int arraySize = scan.nextInt();

           System.out.println("Enter choice of property:\n" +
                   "1. In order\n" +
                   "2. Reverse order\n" +
                   "3. Almost order\n" +
                   "4. Random order");
           int property = scan.nextInt();
            String Prop="";

           int[] arr = new int[arraySize];

        //70% of the array sorted
           int almostOrderLimit = (int) (0.7 * arraySize);
           switch (property) {
               // in order
               case 1:
                   for (int i = 0; i < arraySize; ++i) {
                       arr[i] = i;

                   }
                   Prop =  "InOrder";
                   break;

               //reverse order
               case 2:
                   for (int i = 0; i < arraySize; ++i) {
                       arr[i] = arraySize - i;

                   }
                   Prop =  "ReverseOrder";
                   break;

               //almost order
               case 3:
                   for (int i = 0; i < arraySize; ++i)
                   {
                       if (i < almostOrderLimit)
                           arr[i] = i;
                       else
                           arr[i] = (int) (Math.random() * (Integer.MAX_VALUE) + 1);

                   }

                   Prop =  "AlmostOrder";
                   break;

               //random order
               case 4:
                   for (int i = 0; i < arraySize; i++)
                   {
                       arr[i] = (int) (Math.random() * (Integer.MAX_VALUE) + 1);
                   }
                   Prop =  "Random";
                   break;

               default:
                   System.out.println("Invalid choice entered. Ending the program.");

           }

           System.out.println("Enter choice of sort\n" +
                   "1. Insertion Sort\n" +
                   "2. Selection Sort\n" +
                   "3. Quick Sort\n" +
                   "4. Merge Sort\n" +
                   "5. Heap Sort\n" +
                   "6. Radix Sort");
           int sortChoice = scan.nextInt();

           switch (sortChoice) {
               //Insertion sort
               case 1:
                   insertion obInsertion = new insertion();

                   startTime   = System.nanoTime();
                   obInsertion.insertionSort(arr);
                   endTime   = System.nanoTime();
                   totalTime = endTime - startTime;

                   System.out.println("N: " + arraySize);

                   System.out.println("DataType: " + Prop);

                   System.out.println("Sort: Insertion");

                   System.out.println("Comparisons: " + obInsertion.comparisons);
                   System.out.println("Movements: " + obInsertion.movements);
                   System.out.println("Time: " + totalTime);
                   obInsertion.comparisons = 0;
                   obInsertion.movements = 0;
                   if (winningTime > totalTime)
                   {
                      winningTime = totalTime;
                       winningSort = "Insertion";
                       System.out.println("Winning Algorithm:" + winningSort);
                   }
                   else
                       System.out.println("Winning Algorithm:" + winningSort);

                   break;

                   //Seletion sort
               case 2:
                   selection obSelection = new selection();

                   startTime   = System.nanoTime();
                   obSelection.selectionSort(arr);

                   endTime   = System.nanoTime();
                   totalTime = endTime - startTime;

                   System.out.println("N: " + arraySize);
                   System.out.println("DataType: " + Prop);

                   System.out.println("Sort: Selection");

                   System.out.println("Comparisons: " + obSelection.comparisons);
                   System.out.println("Movements: " + obSelection.movements);
                   System.out.println("Time: " + totalTime);
                   obSelection.comparisons = 0;
                   obSelection.movements = 0;
                   if (winningTime > totalTime)
                   {
                       winningTime = totalTime;
                       winningSort = "Selection";
                       System.out.println("Winning Algorithm:" + winningSort);
                   }
                   else
                       System.out.println("Winning Algorithm:" + winningSort);

                    break;

                    //Quick sort
               case 3:
                   Quick obQuick = new Quick();

                   startTime   = System.nanoTime();
                   obQuick.sort(arr, 0, arr.length - 1);
                   endTime   = System.nanoTime();
                   totalTime = endTime - startTime;

                   System.out.println("N: " + arraySize);
                   System.out.println("DataType: " + Prop);
                   System.out.println("Sort: Quick");

                   System.out.println("Comparisons: " + obQuick.comparisons);
                   System.out.println("Movements: " + obQuick.movements);
                   System.out.println("Time: " + totalTime);
                   obQuick.comparisons = 0;
                   obQuick.movements = 0;
                   if (winningTime > totalTime)
                   {
                       winningTime = totalTime;
                       winningSort = "Quick";
                       System.out.println("Winning Algorithm:" + winningSort);
                   }
                   else
                       System.out.println("Winning Algorithm:" + winningSort);

                    break;

               //Merge Sort
               case 4:
                   merge obMerge = new merge();

                   startTime   = System.nanoTime();
                   obMerge.sort(arr, 0, arr.length - 1);
                   endTime   = System.nanoTime();
                   totalTime = endTime - startTime;

                   System.out.println("N: " + arraySize);
                   System.out.println("DataType: " + Prop);

                   System.out.println("Sort: Merge");

                   System.out.println("Comparisons: " + obMerge.comparisons);
                   System.out.println("Movements: " + obMerge.movements);
                   System.out.println("Time: " + totalTime);
                   obMerge.comparisons = 0;
                   obMerge.movements = 0;
                   if (winningTime > totalTime)
                   {
                       winningTime = totalTime;
                       winningSort = "Merge";
                       System.out.println("Winning Algorithm:" + winningSort);
                   }
                   else
                       System.out.println("Winning Algorithm:" + winningSort);

                   break;

               //Heap sort
               case 5:
                   heap obHeap = new heap();

                   startTime   = System.nanoTime();
                   obHeap.sort(arr);
                   endTime   = System.nanoTime();
                   totalTime = endTime - startTime;

                   System.out.println("N: " + arraySize);
                   System.out.println("DataType: " + Prop);

                   System.out.println("Sort: Heap");

                   System.out.println("Comparisons: " + obHeap.comparisons);
                   System.out.println("Movements: " + obHeap.movements);
                   System.out.println("Time: " + totalTime);
                   obHeap.comparisons = 0;
                   obHeap.movements = 0;
                   if (winningTime > totalTime)
                   {
                       winningTime = totalTime;
                       winningSort = "Heap";
                       System.out.println("Winning Algorithm:" + winningSort);
                   }
                   else
                       System.out.println("Winning Algorithm:" + winningSort);

                   break;


                   //Radix sort
               case 6:
                   heapRadix obRadix = new heapRadix();

                   startTime   = System.nanoTime();

                   heapRadix.radixsort(arr, arraySize);

                   endTime   = System.nanoTime();
                   totalTime = endTime - startTime;

                   System.out.println("N: " + arraySize);
                   System.out.println("DataType: " + Prop);

                   System.out.println("Sort: Radix");

                   System.out.println("Comparisons: " + obRadix.comparisons);
                   System.out.println("Movements: " + obRadix.movements);
                   System.out.println("Time: " + totalTime);
                   obRadix.comparisons = 0;
                   obRadix.movements = 0;
                   if (winningTime > totalTime)
                   {
                       winningTime = totalTime;
                       winningSort = "Radix";
                       System.out.println("Winning Algorithm:" + winningSort);
                   }
                  else
                       System.out.println("Winning Algorithm:" + winningSort);
                   break;
           }
           System.out.println("Press 0 to exit the program. Anything else to continue");
           int check = scan.nextInt();

           if (check == 0)
               repeat = false;
           else
               System.out.println("The program will continue.");

       }while(repeat);

       System.out.println("The program ended. Have a nice day.");
    }
}
