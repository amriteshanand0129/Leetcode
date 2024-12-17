class Solution {
    public int findNext(int[] freq, int i) {
        while(i >= 0) {
            if(freq[i] > 0)
                return i;
            i--;
        }
        return -1;
    }
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++) 
            freq[s.charAt(i) - 'a']++;
        
        StringBuilder sb = new StringBuilder();
        for(int i=25; i>=0; i--) {
            int row = 0;
            outer: while(freq[i] > 0) {
                if(row == repeatLimit) {
                    int index = findNext(freq, i-1);
                    if(index == -1) break outer;
                    sb.append((char)('a' + index));
                    row = 0; freq[index]--;
                }
                sb.append((char)('a' + i));
                row++; freq[i]--;
            }
        }
        return sb.toString();
    }  
}