class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        return dp(m - 1, n - 1, grid);
    }

    private int dp(int m, int n, int[][] grid) {
        if (n == 0 || m == 0) {
            return grid[m][n] = 1;
        }
        if (grid[m][n] != 0){
            return grid[m][n];
        }

        return grid[m][n] = dp(m - 1, n, grid) + dp(m, n - 1, grid);
    }
}
