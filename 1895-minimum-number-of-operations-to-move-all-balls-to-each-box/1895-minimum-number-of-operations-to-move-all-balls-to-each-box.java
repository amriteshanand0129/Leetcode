class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] ans = new int[n];
        for(int i=0; i<n; i++) {
            int cnt = 0, ptr = i - 1;
            while(ptr >= 0) 
                cnt += boxes.charAt(ptr--) == '1' ? i - ptr - 1 : 0;
            ptr = i + 1;
            while(ptr < n) 
                cnt += boxes.charAt(ptr++) == '1' ? ptr - 1 - i : 0;
            ans[i] = cnt;
        }
        return ans;
    }
}