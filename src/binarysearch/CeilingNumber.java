package binarysearch;

public class CeilingNumber {
    public static void main(String[] args) {
        int [] arr = {2,4,8,9,10,14,16,19};
        int target = 15;
        int ans = ceilingOfNumber(arr, target);
        System.out.println(ans);
    }
//    ceiling of a number. means Find the element, if not found return the smallest bigger element
        static int ceilingOfNumber(int [] arr , int target ){

//        if the target is greater than the greatest number in the array
            if (target > arr[arr.length-1]) {
                return -1;
            }

        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            } else if (arr[mid]>target) {
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return start;
    }
}
