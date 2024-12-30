class Solution {
    public int aux(int low, int high, int zero, int one, int len, int[] dp) {

        if(len > high) return 0;

        if(dp[len] != -1) return dp[len];

        int _0 = aux(low, high, zero, one, len + zero, dp);
        int _1 = aux(low, high, zero, one, len + one, dp);

        if(len >= low) return dp[len] = (int)((_0 + _1 + 1) % 1000000007);
        return dp[len] = (int)((_0 + _1) % 1000000007);
    }
    public int countGoodStrings(int low, int high, int zero, int one) {

        int[] dp = new int[high+1];
        Arrays.fill(dp, -1);

        return aux(low, high, zero, one, 0, dp);
    }
}