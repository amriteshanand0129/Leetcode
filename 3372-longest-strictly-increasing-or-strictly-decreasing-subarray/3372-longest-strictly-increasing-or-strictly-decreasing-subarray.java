class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int max_increasing = 1, max_decreasing = 1, curr_increasing = 1, curr_decreasing = 1;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                curr_increasing++; curr_decreasing = 1;
            } else if(nums[i] < nums[i-1]) {
                curr_decreasing++; curr_increasing = 1;
            } else {
                curr_increasing = 1;
                curr_decreasing = 1;
            }
            max_increasing = Math.max(max_increasing, curr_increasing);
            max_decreasing = Math.max(max_decreasing, curr_decreasing);
        }
        return Math.max(max_increasing, max_decreasing);
    }
}