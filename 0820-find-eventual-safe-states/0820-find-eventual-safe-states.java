class Solution {
    public boolean isNodeSafe(int[][] graph, int node, Boolean[] is_safe, boolean[] travelled) {

        // Already calculated
        if(is_safe[node] != null) return is_safe[node];

        // Itself a terminal node
        if(graph[node].length == 0) return is_safe[node] = true;

        // Avoiding loop
        if(travelled[node] == true) return is_safe[node] = false;

        travelled[node] = true;
        int[] paths = graph[node];

        for(int p: paths) {
            if(!isNodeSafe(graph, p, is_safe, travelled)) {
                travelled[node] = false;
                return is_safe[node] = false;
            }
        }

        travelled[node] = false;
        return is_safe[node] = true;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int nodes = graph.length;
        Boolean[] is_safe = new Boolean[nodes];
        boolean[] travelled = new boolean[nodes];

        List<Integer> eventual_safe_nodes = new ArrayList<>();
        for(int i=0; i<nodes; i++) {
            if(isNodeSafe(graph, i, is_safe, travelled)) 
                eventual_safe_nodes.add(i);
        }

        return eventual_safe_nodes;
    }
}