class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0, left = 0, right = 0;
        HashSet<Character> chars = new HashSet<>();
        while(right < s.length()) {
            char ch = s.charAt(right++);
            while(left < s.length() && chars.contains(ch)) 
                chars.remove(s.charAt(left++));
            
            chars.add(ch);
            longest = Math.max(longest, right - left);
        }
        return longest;
    }
}