class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if(n % 2 == 0 && m % 2 == 0) return 0;
        int xor1 = 0, xor2 = 0;
        if(n % 2 != 0) {
            for(int i: nums2) xor1 ^= i;
        } if(m % 2 != 0) {
            for(int i: nums1) xor2 ^= i;
        } 
        return xor1 ^ xor2;
    }
}