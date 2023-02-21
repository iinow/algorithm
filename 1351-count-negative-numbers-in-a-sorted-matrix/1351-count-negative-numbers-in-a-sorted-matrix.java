class Solution {
    public int countNegatives(int[][] grid) {
        int count =0;
         for(int i=0; i<grid.length; i++){
             int end=grid[i].length-1;
            int start=0;
            while(start<=end){
                int mid= start+ (end - start)/2;
                if(grid[i][mid]<0){
                    count=count +end-mid+1; 
                    end=mid-1;
                    
                }
                else if(grid[i][mid] >= 0){
                    start= mid+1;
                }
            }
         }
         
         return count;
    }
}