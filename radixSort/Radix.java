import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

class Radix{
    //radix sort function
    static void radix(int[] arr){
        ArrayList<Integer>[] radixArr = (ArrayList<Integer>[])new ArrayList[10];
        for(int i=0; i<10; i++){
            radixArr[i] = new ArrayList<Integer>();
        }
        //find maxDigits
        int max = arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        int maxDigits = 0;
        while(max>0){
            max/=10;
            maxDigits++;
        }
        //perform sorting
        int exponent = 0;
        int divisor = 1;
        while(exponent < maxDigits){
            for(int i=0; i<arr.length; i++){
                int rIndex = (arr[i]/divisor)%10;
                //System.out.println(rIndex + " " + arr[i]);
                radixArr[rIndex].add(arr[i]);
            }
            int arrayIndex = 0;
            for(int x=0; x<10; x++){
                int curr = 0;
                while(curr < radixArr[x].size()){
                    if(radixArr[x].size()>0){
                        arr[arrayIndex] = radixArr[x].get(curr);
                        arrayIndex++;
                    }
                    curr++;
                }
            }
            for(int y=0; y<10; y++){
                radixArr[y] = null;
                radixArr[y] = new ArrayList<Integer>();
            }
            //Radix.printArray(arr);
            divisor*=10;
            exponent++;
        }
    }
    //main method w/ tests
    public static void main(String[] args) {
        //int arr[] = Radix.readFile("MyList.txt");
        int arr1[] = new int[]{170,45,75,90,802,24,2,66};
        //Test 1
        System.out.print("Testing with arr1: ");
        Radix.printArray(arr1);
        Radix.radix(arr1);
        System.out.print("Result: ");
        Radix.printArray(arr1);
        System.out.println("***********************************");
        int arr2[] = Radix.readFile("MyList.txt");
        System.out.print("Testing with arr2: ");
        Radix.printArray(arr2);
        Radix.radix(arr2);
        System.out.print("Result: ");
        Radix.printArray(arr2);
        System.out.println("***********************************");
    }
    //file io
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
    //printing function
    static void printArray(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}