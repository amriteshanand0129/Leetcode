class Solution {
    public boolean canConstruct(String s, int k) {
        int l = s.length();
        
        if(l < k) return false;
        if(l == k) return true;

        int[] freq = new int[26];
        for(int i=0; i<l; i++) 
            freq[s.charAt(i) - 'a']++;
        
        int odd_count = 0;
        for(int i=0; i<26; i++) {
            if(freq[i] % 2 != 0) 
                odd_count++;
        }

        return odd_count <= k;
    }
}