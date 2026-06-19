package binarysearch;

public class FindInMountainArray {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,1};
        int target = 2;
        System.out.println(search(arr,target));
    }
    static int search(int[] arr, int target){
        int start = 0;
        int end = peakIndex(arr);
        int ans = orderAgnosticBS(arr,target,start,end);
        if(ans==-1){
            start = end+1;
            end = arr.length-1;
            ans = orderAgnosticBS(arr, target, start, end);
        }
        return ans;
    }
    static int peakIndex(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            int mid = start+(end-start)/2;
            if(arr[mid]>arr[mid+1]){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return start;
    }

    static int orderAgnosticBS(int[] arr , int target, int start, int end){
        boolean isAsc = arr[start] < arr[end];

        while(start<=end){
            int mid = start + (end - start) / 2;

            if(arr[mid] == target){
                return mid;
            }
            if(isAsc){
                if(target < arr[mid]) {
                    end = mid-1;
                }
                else{
                    start = mid + 1;
                }
            }
            else{
                if(target > arr[mid]) {
                    end = mid-1;
                }
                else{
                    start = mid + 1;
                }
            }

        }
        return -1;
    }

}
