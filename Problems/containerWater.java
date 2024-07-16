class Solution { 
  public int maxArea(int[] height) { 
    int n=height.length; 
    int left=0; 
    int right=n-1; 
    int maxArea=0,width=0; 
    while(left<right){ 
      int length = Math.min(height[left],height[right]); 
      width=right-left; 
      maxArea=Math.max(maxArea,width*length); 
      if(height[left]==length){ 
      left++; 
      }else{ 
           right--;
      } 
    }  
    return maxArea; 
  } 
} 
