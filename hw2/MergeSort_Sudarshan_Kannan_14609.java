import java.util.Scanner;
import java.io.*;
class MergeSort_Sudarshan_Kannan_14609{
    static void mergeSort(int arr[], int left, int right){
        if(left < right){
            int middle = (left + right)/2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle+1, right);
            merge(arr, left, middle, right);
        }
    }
    static void merge(int[] arr, int left, int middle, int right){
        int size1 = middle - left + 1;
        int size2 = right - middle;
        int leftArr[] = new int[size1];
        int rightArr[] = new int[size2];
        //copy data to arrays
        for(int i=0; i<size1; i++){
            leftArr[i] = arr[left+i];
        }
        for(int j=0; j<size2; j++){
            rightArr[j] = arr[middle+1+j];
        }
        //merge arrays
        int i=0;
        int j=0;
        int k = left;
        while(i<size1 && j<size2){
            if(leftArr[i] <= rightArr[j]){
                arr[k] = leftArr[i];
                i++;
            }
            else{
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while(i<size1){
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while(j<size2){
            arr[k] = rightArr[j];
            j++;
            k++;
        }
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
        int[] arr = MergeSort_Sudarshan_Kannan_14609.readFile("MyList.txt");
        MergeSort_Sudarshan_Kannan_14609.mergeSort(arr,0,arr.length -1);
        MergeSort_Sudarshan_Kannan_14609.printArray(arr);
    }
}