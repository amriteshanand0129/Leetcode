class Solution {
    public int countSubarrays(int[] nums) {
        int count = 0, right = 2;
        while(right < nums.length) {
            if(2 * (nums[right] + nums[right-2]) == nums[right-1])
                count++;
            right++;
        }
        return count;
    }
}