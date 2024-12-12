class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: gifts) 
            pq.add(i);
        
        while(k > 0) {
            pq.add((int)Math.sqrt(pq.poll()));
            k--;
        }

        long sum = 0;
        while(!pq.isEmpty()) {
            sum += pq.poll();
        }

        return sum;
    }
}