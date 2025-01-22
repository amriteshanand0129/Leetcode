class Solution {
    class Cell {
        int row, col;
        Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public void markCells(int[][] heights, Queue<Cell> queue, int height) {
        Queue<Cell> que = new LinkedList<>();
        while(!queue.isEmpty()) {
            Cell cell = queue.poll();
            int row = cell.row, col = cell.col;
            if(heights[row][col] != -1) continue;
            heights[row][col] = height;
            if(row - 1 >= 0 && heights[row-1][col] == -1) que.add(new Cell(row-1, col));
            if(row + 1 < heights.length && heights[row+1][col] == -1) que.add(new Cell(row+1, col));

            if(col - 1 >= 0 && heights[row][col-1] == -1) que.add(new Cell(row, col-1));
            if(col + 1 < heights[0].length && heights[row][col+1] == -1) que.add(new Cell(row, col+1));
        }
        if(!que.isEmpty())
            markCells(heights, que, height+1);
    }
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] heights = new int[m][n];
        for(int i=0; i<m; i++) Arrays.fill(heights[i], -1);

        Queue<Cell> queue = new LinkedList<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(isWater[i][j] == 1)
                    queue.add(new Cell(i, j));
            }
        }

        markCells(heights, queue, 0);
        return heights;
    }
}