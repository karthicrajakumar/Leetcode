// Given a square array of integers A, we want the minimum sum of a falling path through A.

// A falling path starts at any element in the first row, and chooses one element from each row.
// The next row's choice must be in a column that is different from the previous row's column by at most one.

//Input [[1,2,3],[4,5,6],[7,8,9]]

//Output 12

// The possible falling paths are:
// [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
// [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
// [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]

//Recursion

// [1 2 3]
// [4 5 6]
// [7 8 9]
class Solution {
    public int minFallingPathSum(int[][] A) {
        int min = Integer.MAX_VALUE;

        for(int i =0; i< A.length; i++){
            int x =  helper(A,0,i,A.length,dp);
            if( x  < min)
                min = x;
        }

        return min;
    }

    public int helper(int[][] A,int i ,int j, int n){

        if(i == n-1 )
            return A[i][j];
        int s2 = Integer.MAX_VALUE;

        if(j > 0)
            s2 = Math.min(s2,A[i][j] + helper(A,i+1,j-1,n));
        if( j < n-1)
            s2 = Math.min(s2,A[i][j] + helper(A,i+1, j+1,n));

         s2 = Math.min(s2,A[i][j] + helper(A, i+1,j,n));

        return s2;

    }
}

//Memoization
class Solution {
    public int minFallingPathSum(int[][] A) {
        int min = Integer.MAX_VALUE;
        int dp[][] = new int[A.length][A.length];
        for(int i =0; i< A.length; i++){
            int x =  helper(A,0,i,A.length,dp);
            if( x  < min)
                min = x;
        }

        return min;
    }

    public int helper(int[][] A,int i ,int j, int n,int[][] dp){

        if(i == n-1 )
            return A[i][j];
        int s2 = Integer.MAX_VALUE;

        //check memo
        if(dp[i][j] != 0)
            return dp[i][j];
        if(j > 0)
            // going down left
            s2 = Math.min(s2,A[i][j] + helper(A,i+1,j-1,n,dp));
        if( j < n-1)
            // going down right
            s2 = Math.min(s2,A[i][j] + helper(A,i+1, j+1,n,dp));
        //going directly down.
         s2 = Math.min(s2,A[i][j] + helper(A, i+1,j,n,dp));

        //memo
        dp[i][j] = s2;
        return s2;

    }
}

// 0,0 1,0 2,0
