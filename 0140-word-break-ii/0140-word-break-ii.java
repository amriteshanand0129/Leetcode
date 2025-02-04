class Solution {
    List<String> ans = new ArrayList<>();
    HashSet<String> set = new HashSet<>();
    public void auxiliary(String s, int index, String sent) {
        if(index == s.length()) {
            ans.add(sent.substring(1));
            return;
        }
        for(int i=index; i<s.length(); i++) {
            if(set.contains(s.substring(index, i+1)))
                auxiliary(s, i+1, sent + " " + s.substring(index, i+1));
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        for(String str: wordDict) set.add(str);
        auxiliary(s, 0, "");
        Collections.sort(ans, Collections.reverseOrder());
        return ans;        
    }
}