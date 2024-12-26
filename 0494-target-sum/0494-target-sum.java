class Solution {
    int count = 0;
    public void auxiliary(int[] nums, int i, int target) {
        if(i == nums.length) {
            if(target == 0) 
                count++;
            return;
        }
        auxiliary(nums, i+1, target + nums[i]);
        auxiliary(nums, i+1, target - nums[i]);
    }
    public int findTargetSumWays(int[] nums, int target) {
        auxiliary(nums, 0, target);
        return count;
    }
}