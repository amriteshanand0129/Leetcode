class Solution {
    public void fill(char[][] ans, int row, int col, int count) {
        while(count > 0) {
            ans[row--][col] = '#';
            count--;
        }
    }
    public char[][] rotateTheBox(char[][] box) {
        int row = box.length, col = box[0].length;
        int[][] count = new int[row][col+1];
        for(int i=0; i<row; i++) {
            int num = 0;
            for(int j=0; j<col; j++) {
                if(box[i][j] == '#') num++;
                else if(box[i][j] == '*') {
                    count[i][j] = num;
                    num = 0;
                }
            }
            count[i][col] = num;
        }
        char[][] ans = new char[col][row];
        for(int i=0; i<col; i++) Arrays.fill(ans[i], '.');
        int column = 0;
        for(int i=row-1; i>=0; i--) {
            for(int j=0; j<col; j++) {
                if(box[i][j] == '*') {
                    ans[j][column] = '*';
                    fill(ans, j-1, column, count[i][j]);
                }
            }
            if(count[i][col] != 0)
                fill(ans, col-1, column, count[i][col]);
            column++;
        }
        return ans;
    }
}