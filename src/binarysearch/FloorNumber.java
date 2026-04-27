package binarysearch;

public class FloorNumber {
    public static void main(String[] args) {
        int [] arr = {2,4,8,11,23,42,56,};
        int target = 9;
        int ans = floorNumber(arr, target);
        System.out.println(ans);
    }
//    floor of a number. Means find the element or the greatest smaller element.
    static int floorNumber(int [] arr, int target){
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            int mid = start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            } else if (arr[mid]>target) {
                end = mid-1;
            }else{
                start=mid+1;
            }
        }
        return end;
    }
}
