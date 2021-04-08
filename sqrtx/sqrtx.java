class Solution {
    public int mySqrt(int n) {
        if(n==0) return 0;
        int left = 1;
        int right = n;
        int boundaryIndex = -1;
        while (left <= right) {
            int mid = left + (right-left)  / 2;
             if (mid   <= n/mid) {
                boundaryIndex = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return boundaryIndex;
    }
}