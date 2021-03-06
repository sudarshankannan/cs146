import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Problem1{
    static void readFile(String filename, int[] arr){
        //this is a function to read in an array from a text file
        try{
            File myFile = new File(filename);
            Scanner scan = new Scanner(myFile);
            int i = 0;
            while(scan.hasNextInt()){
                arr[i++] = scan.nextInt();
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
    static void printArr(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    static void bubbleSort(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            boolean swapped = false;
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                    swapped = true;
                } 
            }
            if(swapped==false){
                return;
            }
        }
    }
    static void selectionSort(int[] arr){
        for(int j=0; j<arr.length; j++){
            int min_index = j;
            for(int i=j; i<arr.length; i++){
                if(arr[min_index]>arr[i]){
                    min_index = i;
                }
            }
            int temp = arr[j];
            arr[j] = arr[min_index];
            arr[min_index] = temp;
        }
    }
    static void insertionSort(int[] arr){
        for(int i=1; i<arr.length; i++){
            int curr = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>curr){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = curr;
        }
    }
    //this method combines two arrays into one new array
    public static int[] concatenateArrays(int[] arr1, int[] arr2){
        int new_arr_length = arr1.length + arr2.length;
        int[] new_arr = new int[arr1.length+arr2.length];
        int i=0;
        while(i<arr1.length){
            new_arr[i] = arr1[i];
            i++;
        }
        int j = 0;
        while(j<arr2.length){
            new_arr[j+arr1.length] = arr2[j];
            j++;
        }
        return new_arr;
    }
    public static void main(String[] args) {
        //part a
        int[] arr1 =  new int[50];
        Problem1.readFile("arr1.txt",arr1);
        Problem1.bubbleSort(arr1);
        System.out.println("Bubble Sorted Part A is below");
        Problem1.printArr(arr1);
        //part b
        System.out.println("Selection Sorted Part B is below");
        int[] arr2 =  new int[50];
        Problem1.readFile("arr2.txt",arr2);
        Problem1.selectionSort(arr2);
        Problem1.printArr(arr2);
        //part c
        //Concatenate arr1 and arr2 and then perform insertion sort
        System.out.println("Insertion Sorted Part C is below");
        int[] arr3 = Problem1.concatenateArrays(arr1,arr2);
        Problem1.insertionSort(arr3);
        Problem1.printArr(arr3);
    }
}