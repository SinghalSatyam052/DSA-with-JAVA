class Solution {
    public int numIslands(char[][] grid) {
        int cnt = 0;
        int m = grid.length,n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1') cnt++;
                dfs(grid,i,j);
            }
        }
        return cnt;
    }

    void dfs(char[][] grid, int i,int j){
        
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] != '1') return;
        grid[i][j] = 0;
        
        dfs(grid,i-1,j);            
        dfs(grid,i+1,j);            
        dfs(grid,i,j+1);            
        dfs(grid,i,j-1);
    }
}