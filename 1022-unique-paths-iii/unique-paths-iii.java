class Solution {
    int totalCells = 1;  // start point is counted
    int paths = 0;

    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        int startX = 0, startY = 0;

        // Step 1: Count total non-obstacle cells and find the start point
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) totalCells++;
                if(grid[i][j] == 1){
                    startX = i;
                    startY = j;
                }
            }
        }

        // Step 2: Start DFS
        dfs(grid, vis, startX, startY, 0);

        return paths;
    }

    private void dfs(int[][] grid, boolean[][] vis, int x, int y, int count){
        int m = grid.length;
        int n = grid[0].length;

        // Boundary or obstacle or already visited
        if(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == -1 || vis[x][y])
            return;

        // If at destination
        if(grid[x][y] == 2){
            if(count == totalCells) paths++;
            return;
        }

        vis[x][y] = true;

        // Move in all 4 directions
        dfs(grid, vis, x+1, y, count+1);
        dfs(grid, vis, x-1, y, count+1);
        dfs(grid, vis, x, y+1, count+1);
        dfs(grid, vis, x, y-1, count+1);

        vis[x][y] = false; // backtrack
    }
}
