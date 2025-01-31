class Solution {
    public int calculateIslandSize(int[][] grid, int row, int col, int[][] visited) {

        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return 0;
        if(grid[row][col] == 0 || visited[row][col] != 0) return 0;

        visited[row][col] = 1;

        int up = calculateIslandSize(grid, row-1, col, visited);
        int down = calculateIslandSize(grid, row+1, col, visited);
        int right = calculateIslandSize(grid, row, col+1, visited);
        int left = calculateIslandSize(grid, row, col-1, visited);

        return up + down + right + left + 1;
    }
    public void markIslandSize(int[][] grid, int row, int col, int[][][] islandSize, int size, int[][] visited, int islandGroup) {

        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return;
        if(grid[row][col] == 0 || visited[row][col] != 1) return;

        islandSize[row][col][0] = size;
        islandSize[row][col][1] = islandGroup;
        visited[row][col] = 2;

        markIslandSize(grid, row-1, col, islandSize, size, visited, islandGroup);
        markIslandSize(grid, row+1, col, islandSize, size, visited, islandGroup);
        markIslandSize(grid, row, col+1, islandSize, size, visited, islandGroup);
        markIslandSize(grid, row, col-1, islandSize, size, visited, islandGroup);
    }
    public int largestIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][][] islandSize = new int[rows][cols][2];
        int[][] visited = new int[rows][cols]; // 0 -> not visited; 1 -> visited to calculate Island Size; 2 -> visited to mark Island Size;

        int islandGroup = 1;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] == 1 && visited[i][j] == 0) {
                    int size = calculateIslandSize(grid, i, j, visited);
                    markIslandSize(grid, i, j, islandSize, size, visited, islandGroup++);
                }
            }
        }

        int largestIsland = 0;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(grid[i][j] != 0)
                    largestIsland = Math.max(largestIsland, islandSize[i][j][0]);
                else {
                    int size = 1; HashSet<Integer> set = new HashSet<>();
                    if(i > 0 && !set.contains(islandSize[i-1][j][1])) {
                        size += islandSize[i-1][j][0];
                        set.add(islandSize[i-1][j][1]);
                    }
                    if(i < rows-1 && !set.contains(islandSize[i+1][j][1])) {
                        size += islandSize[i+1][j][0];
                        set.add(islandSize[i+1][j][1]);
                    }
                    if(j > 0 && !set.contains(islandSize[i][j-1][1])) {
                        size += islandSize[i][j-1][0];
                        set.add(islandSize[i][j-1][1]);
                    }
                    if(j < cols-1 && !set.contains(islandSize[i][j+1][1])) {
                        size += islandSize[i][j+1][0];
                        set.add(islandSize[i][j+1][1]);
                    }
                    largestIsland = Math.max(largestIsland, size);
                }
            }
        }
        return largestIsland;
    }
}