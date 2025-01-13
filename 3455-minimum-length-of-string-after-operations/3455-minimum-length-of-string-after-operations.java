class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for(int i=0; i<n; i++) 
            freq[s.charAt(i) - 'a']++;
        
        for(int i: freq) {
            if(i != 0)
                n -= ((i + 1) / 2 - 1) * 2;
        }
        return n;
    }
}