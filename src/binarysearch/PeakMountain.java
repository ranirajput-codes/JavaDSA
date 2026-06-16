package binarysearch;

public class PeakMountain {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,3,1};
        System.out.println(peakIndex(arr));
    }
    static int peakIndex(int[] arr){
        int start = 0;
        int end = arr.length-1;

        while(start<end){
             int mid = start + (end-start)/2;
            if (arr[mid] > arr[mid+1]) {
                //you are in the decreasing part
                //this may be the answer, but look at left
                //this is why end != mid-1;
                end = mid;
            }else if(arr[mid]<arr[mid+1]){
                //you are in the ascending part
                start = mid+1; // because we know mid+1 is greater than mid
            }
        }
        //in the end, start == end and pointing to the peak element (largest number)
        //start and end are always trying to find the max in the above two checks
        //hence, when they are pointing to just one element, that is the maximum one because that is what the checks say
        //more elaboration: at every point of time for start and end, they have the best possible answer till that time
        //and if we are saying that only one item is remaining, hence because of the above line that is the best possible ans
        return start; // or we can return end as both are equal
    }
}
