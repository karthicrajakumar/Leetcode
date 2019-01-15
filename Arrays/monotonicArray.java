// An array is monotonic if it is either monotone increasing or monotone decreasing.

// An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].

// Return true if and only if the given array A is monotonic.



// Example 1:

// Input: [1,2,2,3]
// Output: true

class Solution {
    public boolean isMonotonic(int[] A) {
        if(A.length == 1)
            return true;
        int i =1;
        boolean inc = false;
        while( A[i] == A[i-1]  ){
            if( i == A.length -1)
                return true;
            i++;
        }
        i = i -1;
        if( A[i] < A[i+1])
            inc = true;
        for(int x = i; x < A.length-1; x++){
            if(inc){
                if(A[x] > A[x+1])
                    return false;

            }else
                if(A[x] < A[x+1])
                    return false;
        }

        return true;
    }
}
