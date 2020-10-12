import java.util.Scanner;
import java.io.*;
class QuickSort_Sudarshan_Kannan_1409{
    static void quickSort(int[] arr, int low, int high){
        if(low<high){
            int partitionIndex = doPartition(arr,low,high);
            quickSort(arr,low,partitionIndex-1);
            quickSort(arr,partitionIndex+1,high);
        }
    }
    static int doPartition(int arr[], int low, int high){
        int pivot = arr[high];
        int i = (low-1);
        for(int j=low; j<high; j++){
            if(arr[j]<pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
    static int[] readFile(String filename){
        //this is a function to read in an array from a text file
        File myFile = null;
        Scanner scan = null;
        int[] arr = null;
        try{
            myFile = new File(filename);
            scan = new Scanner(myFile);
            int i = 0;
            while(scan.hasNextInt()){
                scan.nextLine();
                i++;
            }
            myFile = new File(filename);
            scan = new Scanner(myFile);
            int z = 0;
            arr = new int[i];
            while(scan.hasNextInt()){
                arr[z] = Integer.parseInt(scan.nextLine());
                z++;
            }
        }
        catch(IOException e){
            System.out.println(e.toString());
        }
        finally{
            scan.close();
        }
        return arr;
    }
    static void printArray(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = QuickSort_Sudarshan_Kannan_1409.readFile("MyList.txt");
        QuickSort_Sudarshan_Kannan_1409.quickSort(arr,0,arr.length -1);
        QuickSort_Sudarshan_Kannan_1409.printArray(arr);
    }
}