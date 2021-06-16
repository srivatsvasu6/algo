class Solution {
    public int maximalRectangle(char[][] matrix) {
       int n = matrix.length;
        if(n==0)
            return 0;
        int m = matrix[0].length;
        int[] height = new int[m];
        int max = 0;
        for(int i=0; i<n; i++){
          for(int j =0; j<m; j++)
            
           { 
              
              if(matrix[i][j]=='0'){
                  height[j] = 0;
              }
              else{
                   height[j] += 1;
              }
            }
            
            max = Math.max(max, findArea(height));
        }
        
    

        return max;
    }
    
  
    public int findArea(int[] height){
        
        Stack<Integer> stack = new Stack<>();
        
        int i=0, area, max=0;
        while(i<height.length){
            
            if(stack.isEmpty() || height[stack.peek()]<= height[i] ){
                stack.push(i++);
            }else{
                int top = stack.pop();
                
                if(stack.isEmpty()){
                    area = height[top] * i;
                }else{
                    area = height[top] * (i - stack.peek() -1);
                }
                max = Math.max(max, area);
                
            }
         

        }
        
        
        while(!stack.isEmpty()){
            int top = stack.pop();
                
                if(stack.isEmpty()){
                    area = height[top] * i;
                }else{
                    area = height[top] * (i - stack.peek() -1);
                }
                max = Math.max(max, area);
            
        }
        
        return max;
    }
}