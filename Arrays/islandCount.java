// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

// Example 1:

// Input:
// 11110
// 11010
// 11000
// 00000

// Output: 1

class Solution {
    int[][] visited;
    char [][] grid2;
    int n,m;
    public int numIslands(char[][] grid) {
        try {
            n = grid.length;
            m = grid[0].length;

            visited = new int[n][m];
            grid2 = grid;
        }catch( Exception e){
            return 0;
        }

        int count =0;
        for(int i =0 ;i< n; i++){
            for(int j =0 ; j< m; j++){
                if(visited[i][j] != 1 && grid[i][j] == '1'){
                    mark(i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void mark(int i, int j){
        visited[i][j] =1;
        if(grid2[i][j] == '1'){
            if(i <  n-1 && visited[i+1][j] == 0) mark(i+1,j);
            if(i > 0 && visited[i-1][j] == 0) mark(i-1,j);
            if(j < m-1 && visited[i][j+1] == 0) mark(i,j+1);
            if(j > 0 && visited[i][j-1] == 0)mark(i,j-1);
        }

        return;
    }
}
