class Solution {
    class Cell {
        int row, col;
        Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        HashMap<Integer, Cell> map = new HashMap<>();
        for(int i=0; i<rows; i++) 
            for(int j=0; j<cols; j++) 
                map.put(mat[i][j], new Cell(i, j));
            
        HashMap<Integer, Integer> row = new HashMap<>(); // row_index, count of cols painted
        HashMap<Integer, Integer> col = new HashMap<>(); // col_index, count of rows painted

        for(int i=0; i<arr.length; i++) {
            Cell cell = map.get(arr[i]);
            row.put(cell.row, row.getOrDefault(cell.row, 0) + 1);
            col.put(cell.col, col.getOrDefault(cell.col, 0) + 1);

            int painted_cols = row.get(cell.row);
            int painted_rows = col.get(cell.col);

            if(painted_rows == rows || painted_cols == cols) return i;
        }

        return -1;
    }
}