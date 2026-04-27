package binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int [] arr = {-23,-10,-1,0,8,23,38,45,89,100};
        int target = -1;
        int ans = binarySearch(arr,target);
        System.out.println(ans);
    }

    //return the index
    //return -1 if it doesn't exist
    static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        while(start<=end){
            //find the middle element
            // int mid = (start+end)/2 ;  // might be possible that (start + end ) exeeds the range of intiger in java
            int mid = start + (end - start) / 2;

            if(target < arr[mid]) {
                end = mid-1;
            }
            else if(target > arr[mid]){
                start = mid + 1;
            }
            else {
                // answer found
                return mid;
            }

        }
        return -1;
    }

}
