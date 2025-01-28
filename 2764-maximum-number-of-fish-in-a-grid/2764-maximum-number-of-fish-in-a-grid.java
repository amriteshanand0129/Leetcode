class Solution {
    public int maxFish = 0, fishes = 0;

    public void catchFish(int[][] grid, boolean catched[][], int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || catched[i][j] || grid[i][j] == 0)
            return;

        fishes += grid[i][j];
        maxFish = Math.max(maxFish, fishes);
        catched[i][j] = true;

        catchFish(grid, catched, i + 1, j);
        catchFish(grid, catched, i - 1, j);
        catchFish(grid, catched, i, j + 1);
        catchFish(grid, catched, i, j - 1);
    }

    public int findMaxFish(int[][] grid) {

        int n = grid.length, m = grid[0].length;
        boolean[][] catched = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!catched[i][j]) {
                    fishes = 0;
                    catchFish(grid, catched, i, j);
                }
            }
        }

        return maxFish;
    }
}