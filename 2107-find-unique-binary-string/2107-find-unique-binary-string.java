class Solution {
    public String createBinary(String s, int n, HashSet<String> set) {
        if(s.length() == n) {
            if(set.contains(s))
                return "";
            return s;
        }
        String s1 = createBinary(s + 1, n, set);

        if(s1 != "")
            return s1;
        
        return createBinary(s + 0, n, set);
    }
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set = new HashSet<>();
        for(String s: nums)
            set.add(s);
        
        return createBinary("", nums[0].length(), set);
    }
}