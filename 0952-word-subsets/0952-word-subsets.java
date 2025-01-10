class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] subset = new int[26];
        for(String word: words2) {
            int[] temp_subset = new int[26];
            for(int i=0; i<word.length(); i++) 
                temp_subset[word.charAt(i) - 'a']++;
            for(int i=0; i<26; i++)
                subset[i] = Math.max(subset[i], temp_subset[i]);
        }

        List<String> ans = new ArrayList<>();
        outer: for(String word: words1) {
            int[] set = new int[26];
            for(int i=0; i<word.length(); i++)
                set[word.charAt(i) - 'a']++;
            for(int i=0; i<26; i++) {
                if(set[i] < subset[i])
                    continue outer;
            }
            ans.add(word);
        }
        
        return ans;
    }
}