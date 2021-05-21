class Solution {
    public int firstMissingPositive(int[] A) {
        int n = A.length;
       for(int i = 0; i < n; ++i)
            while(A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i])
                swap(A, i, A[i]-1);
        
        for(int i = 0; i < n; ++ i)
            if(A[i] != i + 1)
                return i + 1;
        
        return n + 1;
        
    }
    public void swap(int[] arr, int i, int  j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}