class Solution {
    public boolean serversCanCommunicate(int[][] grid, int row, int[] server_in_col) {
        int j = 0;
        while(j < grid[0].length) {
            if(grid[row][j] == 1)
                break;
            j++;
        }
        return server_in_col[j] > 1;
    }
    public int countServers(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[] servers_in_row = new int[rows];
        int[] servers_in_col = new int[cols];

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 1) {
                    servers_in_row[i]++;
                    servers_in_col[j]++;
                }
            }
        }

        int connected_servers = 0;
        for(int i=0; i<rows; i++) {
            if(servers_in_row[i] > 1 || (servers_in_row[i] == 1 && serversCanCommunicate(grid, i, servers_in_col))) 
                connected_servers += servers_in_row[i];
        }

        return connected_servers;
    }
}