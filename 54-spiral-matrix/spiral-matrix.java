class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int startRow = 0, endRow = matrix.length;
        int startCol = 0, endCol = matrix[0].length;
        
        List<Integer> ans = new ArrayList<>();

        while(startRow < endRow && startCol < endCol){
            for(int j = startCol;j<endCol;j++){
                ans.add(matrix[startRow][j]);
            }
            startRow+=1;
            for(int i=startRow; i< endRow;i++){
                ans.add(matrix[i][endCol-1]);
            }
            endCol-=1;
            if(startRow < endRow){
                for(int j = endCol-1;j>=startCol;j--){
                    ans.add(matrix[endRow-1][j]);
                }
            }
            endRow-=1;
            if(startCol < endCol){
                for(int i=endRow-1;i>=startRow;i--){
                    ans.add(matrix[i][startCol]);
                }
            }
            startCol+=1;
        }

        return ans;
    }
}