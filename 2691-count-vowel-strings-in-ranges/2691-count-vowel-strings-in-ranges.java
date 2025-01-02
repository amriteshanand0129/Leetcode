class Solution {
    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'o' || ch == 'i' || ch == 'u';
    }
    public boolean vowelString(String s) {
        return isVowel(s.charAt(0)) && isVowel(s.charAt(s.length() - 1));
    }
    public int[] vowelStrings(String[] words, int[][] queries) {

        int n = words.length, m = queries.length;

        int[] freq = new int[n];
        freq[0] = vowelString(words[0]) ? 1 : 0;
        for(int i=1; i<n; i++) 
            freq[i] = vowelString(words[i]) ? freq[i-1] + 1 : freq[i-1];
        
        int[] ans = new int[m];
        for(int i=0; i<m; i++) 
            ans[i] = freq[queries[i][1]] - (queries[i][0] == 0 ? 0 : freq[queries[i][0] - 1]);
        
        return ans;
    }
}