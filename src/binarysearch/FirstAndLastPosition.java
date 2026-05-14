package binarysearch;
import java.util.Arrays;

public class FirstAndLastPosition {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 7;
        int[] ans = searchRange(nums,target);
        System.out.println(Arrays.toString(ans));
    }

    static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        int start = 0;
        int end = nums.length-1;
        // finding first index
        while(start<=end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                ans[0] = mid;
                end = mid - 1;
            }
            else if (nums[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        //finding second index
        start = 0;
        end = nums.length-1;
        while(start<=end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                ans[1] = mid;
                start = mid + 1;
            }
            else if (nums[mid] < target) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
