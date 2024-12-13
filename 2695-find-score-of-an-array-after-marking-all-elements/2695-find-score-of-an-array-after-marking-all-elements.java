class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            pq.add(nums[i]);
            if(map.containsKey(nums[i])) 
                map.get(nums[i]).add(i);
            else {
                PriorityQueue<Integer> prq = new PriorityQueue<>();
                prq.add(i);
                map.put(nums[i], prq);
            }
        }
        long score = 0;
        HashSet<Integer> set = new HashSet<>();
        while(!pq.isEmpty()) {
            int num = pq.poll();
            int index = map.get(num).poll();
            if(!set.contains(index)) {
                score += num;
                set.add(index);
                set.add(index+1);
                set.add(index-1);
            }
        }
        return score;
    }
}