package binarysearch;
// LeetCode 410

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int m = 2;
        System.out.println(splitArray(nums, m));
    }
    static int splitArray(int[] nums, int m){
        int start = 0;
        int end = 0;
        for(int num: nums){
            start = Math.max(start, num);
            end = end + num;
        }
        while(start<end){
            int mid = start+(end-start)/2;
            int pieces = 1;
            int sum = 0;
            for(int num : nums){
                if(sum + num > mid){
                    sum = num;
                    pieces++;
                }else{
                    sum = sum+ num;
                }
            }
            if(pieces<= m){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return start;
    }
}
