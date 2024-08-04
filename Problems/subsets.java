public class Solution { 
  public List<List<Integer>> subsets(int[] nums) { 
    List<List<Integer>> result = new ArrayList<>(); 
    backtrack(result, new ArrayList<>(), nums, 0); 
    return result; 
    } 
    private void backtrack(List<List<Integer>> result, List<Integer> subset, int[] nums, int start) { 
    result.add(new ArrayList<>(subset));  // Add current subset to results 
    for (int i = start; i < nums.length; i++) { 
    subset.add(nums[i]);  // Include current element in subset 
    backtrack(result, subset, nums, i + 1);  // Recursively build subsets starting from i+1 
    subset.remove(subset.size() - 1);  // Backtrack: remove last added element 
    } 
  } 
}
