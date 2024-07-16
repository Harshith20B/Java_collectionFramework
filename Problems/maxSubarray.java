class Solution { 
  public int maxSubArray(int[] nums) { 
    return divideAndConquer(nums, 0, nums.length - 1); 
  } 
  private int divideAndConquer(int[] nums, int left, int right) { 
  if (left == right) { 
    return nums[left]; 
  } 
  int mid = left + (right - left) / 2; 
  int leftMax = divideAndConquer(nums, left, mid); 
  int rightMax = divideAndConquer(nums, mid + 1, right); 
  int crossMax = findMaxCrossingSubarray(nums, left, mid, right); 
  return Math.max(Math.max(leftMax, rightMax), crossMax); 
  } 
  private int findMaxCrossingSubarray(int[] nums, int left, int mid, int right) { 
  int leftSum = Integer.MIN_VALUE; 
  int sum = 0; 
  for (int i = mid; i >= left; i--) { 
    sum += nums[i]; 
    if (sum > leftSum) { 
      leftSum = sum; 
    } 
  } 
  int rightSum = Integer.MIN_VALUE; 
  sum = 0; 
  for (int i = mid + 1; i <= right; i++) { 
  sum += nums[i]; 
  if (sum > rightSum) { 
  rightSum = sum; 
  } 
  } 
  return leftSum + rightSum; 
  } 
}
