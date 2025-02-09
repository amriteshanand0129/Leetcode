class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Long> count = new HashMap<>();
        long n = nums.length;
        for(int i=0; i<n; i++) {
            int diff = nums[i] - i;
            count.put(diff, count.getOrDefault(diff, (long)0) + 1);
        }

        long totalPairs = (n * (n-1)) / 2;
        long goodPairs = 0;
        for(long i: count.values()) {
            if(i > 1) {
                goodPairs += (i * (i-1)) / 2;
            }
        }

        return totalPairs - goodPairs;
    }
}