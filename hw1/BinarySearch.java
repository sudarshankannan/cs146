class BinarySearch{
    //binary search on an array of integers
    static void binarySearch(int[] arr, int num){
        int len = arr.length;
        int currIndex = len/2;
        int low = 0;
        int high = len-1;
        int mid;
        while(low <= high){
            mid = low + (high - low)/2;
            //check if index mid contains num
            if(arr[mid]==num){
                System.out.println(mid + " contains " + num);
                return;
            }
            if(arr[mid] < num){
                low = mid + 1;
            }
            else{
                high = mid-1;
            }
        }
        System.out.println("Your searched number is not found");
    }
    //main method
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,77,88,90,105,110,121,125,159};
        //test last index
        BinarySearch.binarySearch(arr,159);
        //test first index
        BinarySearch.binarySearch(arr,1);
        //test middle value + 1
        BinarySearch.binarySearch(arr,110);
        //test something else
        BinarySearch.binarySearch(arr,77);
    }
}