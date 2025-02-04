class Solution {
    public int maxAscendingSum(int[] nums) {
        int max_sum = nums[0], sum = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(nums[i] <= nums[i-1]) 
                sum = nums[i];
            else {
                sum += nums[i];
                max_sum = Math.max(max_sum, sum);
            }
        }
        return max_sum;
    }
}