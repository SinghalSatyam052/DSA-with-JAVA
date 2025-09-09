class Solution {
    public int orangesRotting(int[][] grid) {

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    dfs(i,j,grid,0);
                }
            }
        }        
        int time = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) return -1;
                time = Math.max(time,grid[i][j]-2);
                
            }
        }

        return time;
    }

    private void dfs(int row, int col, int[][] grid, int time){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return;
        if(grid[row][col] == 0) return;    
        if(grid[row][col] > 1 && grid[row][col] < time + 2) return;


        grid[row][col] = time + 2;
        
        dfs(row + 1, col, grid, time + 1);
        dfs(row, col + 1, grid, time + 1);
        dfs(row - 1, col, grid, time + 1);
        dfs(row, col - 1, grid, time + 1);
        
    }
}