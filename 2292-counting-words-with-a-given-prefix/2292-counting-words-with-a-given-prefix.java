class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for(String word : words) {
            count += word.startsWith(pref) ? 1 : 0;
        } 
        return count;
    }
}