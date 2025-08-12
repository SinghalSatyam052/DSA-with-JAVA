class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> ans = new ArrayList<>();

        int[][] board = new int[8][8];
        for(int[] cord:queens){
            board[cord[0]][cord[1]] = 1;
        }

        int i = king[0];
        int j = king[1];

        //left up
        while(--i>=0 && --j>=0){
            if(board[i][j] == 1){
                ans.add(new ArrayList<>(Arrays.asList(i, j)));
                break;
            }
        }
        i = king[0];
        j = king[1];

        //up
        while(--i>=0){
            if(board[i][j] == 1){
                ans.add(new ArrayList<>(Arrays.asList(i, j)));
                break;
            }
        }
        i = king[0];
        j = king[1];

        //right up
        while(--i>=0 && ++j<8){
            if(board[i][j] == 1){
                ans.add(new ArrayList<>(Arrays.asList(i, j)));
                break;
            }
        }
        i = king[0];
        j = king[1];

        //right
        while(++j<8){
            if(board[i][j] == 1){
                ans.add(new ArrayList<>(Arrays.asList(i, j)));
                break;
            }
        }
        i = king[0];
        j = king[1];

        //right bottom
        while(++i<8 && ++j<8){
            if(board[i][j] == 1){
                ans.add(new ArrayList<>(Arrays.asList(i, j)));
                break;
            }
        }
        i = king[0];
        j = king[1];

        // bottom
        while(++i<8){
            if(board[i][j] == 1){
                ans.add(new ArrayList<>(Arrays.asList(i, j)));
                break;
            }
        }
        i = king[0];
        j = king[1];

        //left bottom
        while(++i<8 && --j>=0){
            if(board[i][j] == 1){
                ans.add(new ArrayList<>(Arrays.asList(i, j)));
                break;
            }
        }
        i = king[0];
        j = king[1];

        //left
        while(--j>=0){
            if(board[i][j] == 1){
                ans.add(new ArrayList<>(Arrays.asList(i, j)));
                break;
            }
        }
        
        return ans;
    }

}