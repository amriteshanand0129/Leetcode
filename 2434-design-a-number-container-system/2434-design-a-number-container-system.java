class NumberContainers {

    HashMap<Integer, Integer> container;
    HashMap<Integer, PriorityQueue<Integer>> map;
    public NumberContainers() {
        this.container = new HashMap<>();
        this.map = new HashMap<>();
    }
    
    public void change(int index, int number) {
        this.container.put(index, number);
        if(this.map.containsKey(number)) {
            this.map.get(number).add(index);
        } else {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.add(index);
            this.map.put(number, pq);
        }
    }
    
    public int find(int number) {
        if(this.map.containsKey(number) && !this.map.get(number).isEmpty()) {
            PriorityQueue<Integer> pq = this.map.get(number);        
            while(!pq.isEmpty() && container.get(pq.peek()) != number)
                pq.poll();
            return pq.isEmpty() ? -1 : pq.peek();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */