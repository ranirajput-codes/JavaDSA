package binarysearch;

public class RotationCount {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2,3};
        System.out.println(countRotations(arr));
    }
    static int countRotations(int[] arr){
        int pivot = findPivot(arr);
//        if(pivot==-1){
//            // it means the array is not rotated
              // not imp to write because -1+1 = 0
//            return 0;
//        }
        return pivot+1;
    }
    // Use this for non duplicates
    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length;
        while(start<=end){
            int mid = start+(end-start)/2;
            // 4 cases over here
            if(mid<end && arr[mid]>arr[mid+1]){
                return mid;
            }if(mid>start && arr[mid]<arr[mid-1]){
                return mid-1;
            }if(arr[start]>=arr[mid]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }
    //Use this when arr contains duplicates
    static int findPivotWithDuplicates(int[] arr){
        int start = 0;
        int end = arr.length;
        while(start<=end){
            int mid = start+(end-start)/2;
            // 4 cases over here
            if(mid<end && arr[mid]>arr[mid+1]){
                return mid;
            }if(mid>start && arr[mid]<arr[mid-1]){
                return mid-1;
            }
            //if elements at middle, start, end are equal then just skip the duplicates
            if(arr[mid]==arr[start] && arr[mid]==arr[end]){
                //skip the duplicates

                //Note: what if these elements at start and end were the pivot?
                //check if the start is pivot
                if(start<end && arr[start]>arr[start+1]){
                    return start;
                }
                start++;
                //check whether end is pivot
                if(arr[end]<arr[end-1]){
                    return end-1;
                }
                end--;
            }
            //left side is sorted, so pivot should be right
            else if(arr[start]<arr[mid] || (arr[start]==arr[mid] && arr[mid] > arr[end])){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }
}
