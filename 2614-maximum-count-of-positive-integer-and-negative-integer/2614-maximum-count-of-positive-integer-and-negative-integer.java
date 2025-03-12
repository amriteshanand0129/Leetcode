class Solution {
    public int maximumCount(int[] nums) {
        int pos = 0, neg = 0;
        for(int i: nums) {
            pos += (i > 0 ? 1 : 0);
            neg += (i < 0 ? 1 : 0);
        }
        return Math.max(pos, neg);
    }
}