class Solution {
    public int maxProduct(int[] A) {
       int r = A[0];

    // imax/imin stores the max/min product of
    // subarray that ends with the current number A[i]
    for (int i = 1, imax = r, imin = r; i < A.length; i++) {
        // multiplied by a negative makes big number smaller, small number bigger
        // so we redefine the extremums by swapping them
        if (A[i] < 0)
         {
        int tmp = imax;
            imax = imin;
            imin = tmp;
        }
        // max/min product for the current number is either the current number itself
        // or the max/min by the previous number times the current one
        imax = Math.max(A[i], imax * A[i]);
        imin = Math.min(A[i], imin * A[i]);

        // the newly computed max value is a candidate for our global result
        r = Math.max(r, imax);
    
        
    }
        
        return r;
    }
}