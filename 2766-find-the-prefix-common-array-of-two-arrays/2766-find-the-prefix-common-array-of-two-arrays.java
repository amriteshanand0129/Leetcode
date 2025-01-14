class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer> a = new HashSet<>();
        HashSet<Integer> b = new HashSet<>();
        int n = A.length;
        int[] ans = new int[n];
        ans[0] = A[0] == B[0] ? 1 : 0;
        a.add(A[0]); b.add(B[0]);
        for(int i=1; i<n; i++) {
            a.add(A[i]);
            b.add(B[i]);
            ans[i] = ans[i-1];
            if(a.contains(B[i]))
                ans[i]++;
            if(A[i] != B[i] && b.contains(A[i]))
                ans[i]++;
        }
        return ans;
    }
}