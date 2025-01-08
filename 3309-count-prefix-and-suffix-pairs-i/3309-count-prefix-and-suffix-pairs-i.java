class Solution {
    public boolean isPrefixAndSuffix(String str1, String str2) {
        int l1 = str1.length(), l2 = str2.length();
        return l2 >= l1 && str2.substring(0, l1).equals(str1) && str2.substring(l2 - l1).equals(str1);
    }
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for(int i=0; i<words.length; i++) 
            for(int j=i+1; j<words.length; j++) 
                count += isPrefixAndSuffix(words[i], words[j]) ? 1 : 0;
            
        return count;
    }
}