import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Problem1{
    static void readFile(String filename, int[] arr){
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
            System.out.println(min_index + " " + arr[min_index] + " " + arr[j]);
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
    public static void main(String[] args) {
        //part a
        int[] arr1 =  new int[50];
        Problem1.readFile("arr1.txt",arr1);
        //Problem1.bubbleSort(arr1);
        //Problem1.printArr(arr1);
        //part b
        int[] arr2 =  {64,25,12,22,11};
        //Problem1.readFile("arr2.txt",arr2);
        Problem1.selectionSort(arr2);
        Problem1.printArr(arr2);
        //part c
        
    }
}