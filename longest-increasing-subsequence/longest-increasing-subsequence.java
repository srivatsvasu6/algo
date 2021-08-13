class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int  len = 0 ;
     int [] a = new int [nums.length];
    for( int val : nums) {
         int  index = binary(a, 0 , len - 1 , val);
        a[ index ] = val;
        // Explain that this number is newly added to this array
        if ( len == index ) len ++;
    }
    return len ;
}

// It is equivalent to finding the insertion position of val in the left - right interval. Guarantee ascending order;
public int binary( int [] a, int  left , int  right , int val) {
    while( left <= right ) {
         int  mid = getMid( left , right );
         if (a[ mid ] >= val) {
             right = mid - 1 ;
        }
        // Replace this value if it is equal;
        else {
            left = mid + 1 ;
        }
    }
    return left ;
}

public int getMid( int  left , int  right ) {
    return left + ( right - left ) / 2 ;
}
}