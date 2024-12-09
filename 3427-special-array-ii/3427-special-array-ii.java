class Solution {
    public boolean checkParity(int a, int b) {
        if((a % 2 == 0 && b % 2 == 0) || (a % 2 != 0 && b % 2 != 0)) return false;
        return true;
    }
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] parity = new int[n];
        parity[0] = 1;
        for(int i=1; i<n; i++) {
            if(checkParity(nums[i], nums[i-1]))
                parity[i] = parity[i-1] + 1;
            else
                parity[i] = parity[i-1];
        }

        boolean[] ans = new boolean[queries.length];
        for(int i=0; i<queries.length; i++) {
            int start = queries[i][0]; 
            int end = queries[i][1];
            if(parity[end] - parity[start] == end - start)
                ans[i] = true;
        }

        return ans;
    }
}