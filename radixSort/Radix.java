import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

class Radix{
    static void radix(int[] arr){
        ArrayList<Integer> radixArr[] = null;
        for(int i=0; i<10; i++){
            radixArr[i] = new ArrayList<Integer>();
        }
    }
    public static void main(String[] args) {
        int arr[] = Radix.readFile("MyList.txt");
        Radix.radix(arr);
        Radix.printArray(arr);
    }
    //miscellaneous helper functions
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
}