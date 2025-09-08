class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] != color) dfs(sr,sc,color,image[sr][sc],image);
        return image;
    }
    private void dfs(int i, int j, int color, int original, int[][] grid){
        if(i<0 || j<0 || i >= grid.length || j>= grid[0].length) return;

        if(grid[i][j] == original) grid[i][j] = color;
        else return;

        dfs(i+1,j,color,original,grid);
        dfs(i,j+1,color,original,grid);
        dfs(i-1,j,color,original,grid);
        dfs(i,j-1,color,original,grid);
    }
}