package binarysearch;
import java.util.Arrays;

public class FirstAndLastPosition {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 7;
        int[] answer = searchRange(nums,target);
        System.out.println(Arrays.toString(answer));
    }

    static int[] searchRange(int[] nums, int target) {
        int[] answer = {-1, -1};
        answer[0] = ans(nums, target,true);
        answer[1] = ans(nums, target, false);
        return answer;

    }

    static int ans(int[] nums, int target, boolean firstindex){
        int ans = -1;
        int start = 0;
        int end = nums.length-1;

        while(start<=end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                ans = mid;
                if(firstindex) {
                    end = mid - 1;  //to find first index
                }else{
                    start = mid+1;  //to find second index
                }
            }
            else if (nums[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
