class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> balls = new HashMap<>();
        int[] ans = new int[queries.length];
        int index = 0;

        for(int[] query: queries) {
            int colour = balls.getOrDefault(query[0], 0);
            if(colour != 0) {
                int count = map.get(colour);
                if(count == 1)
                    map.remove(colour);
                else
                    map.put(colour, count-1);
            }
            balls.put(query[0], query[1]);
            map.put(query[1], map.getOrDefault(query[1], 0) + 1);
            ans[index++] = map.size();
        }

        return ans;
    }
}