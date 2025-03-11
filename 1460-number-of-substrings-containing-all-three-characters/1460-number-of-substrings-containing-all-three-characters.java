class Solution {
    public boolean satisfiesCondition(int count[][], int left, int right) {
        int a = count[right][0] - (left > 0 ? count[left-1][0] : 0);
        int b = count[right][1] - (left > 0 ? count[left-1][1] : 0);
        int c = count[right][2] - (left > 0 ? count[left-1][2] : 0);

        return a > 0 && b > 0 && c > 0;
    }
    public int numberOfSubstrings(String s) {

        int ans = 0, n = s.length(), left = 0, right = 0;
        int count[][] = new int[n][3];
        char ch = s.charAt(0);

        count[0][0] = ch == 'a' ? 1 : 0;
        count[0][1] = ch == 'b' ? 1 : 0;
        count[0][2] = ch == 'c' ? 1 : 0;
        for(int i=1; i<n; i++) {
            ch = s.charAt(i);
            count[i][0] = ch == 'a' ? count[i-1][0] + 1 : count[i-1][0];
            count[i][1] = ch == 'b' ? count[i-1][1] + 1 : count[i-1][1];
            count[i][2] = ch == 'c' ? count[i-1][2] + 1 : count[i-1][2];
        }

        while(right < n) {
            if(satisfiesCondition(count, left, right)) {
                ans += n - right;
                left++;
            } else {
                right++;
            }
        }

        return ans;
    }
}