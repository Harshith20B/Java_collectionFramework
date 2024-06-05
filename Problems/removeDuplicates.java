package Problems;
class removeDuplicates {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int arr[] = new int[len];
        int k=0;
        for(int i=0;i<len-1;i++,k++){
            if(nums[i]==nums[i+1]){
                for(int j=i+1;j<len-1;j++){
                    if(nums[j]!=nums[j+1]){
                        break;
                    }
                    i++;
                }
            }
            arr[k]=nums[i];
        }
        arr[k] = nums[len-1]; // since k++ at last
        for(int i=0;i<k+1;i++){
            nums[i]=arr[i];
        }
        return (k+1);
    }
    public static void main(String args[]){
        int arr[] = {1,2,3};
        removeDuplicates obj = new removeDuplicates();
        obj.removeDuplicates(arr);
    }
}
// class Solution {
//     public int removeDuplicates(int[] nums) {
//         if (nums.length <= 2) {
//             return nums.length;
//         }

//         int uniqueIndex = 2;

//         for (int i = 2; i < nums.length; i++) {
//             if (nums[i] != nums[uniqueIndex - 2]) {
//                 nums[uniqueIndex] = nums[i];
//                 uniqueIndex++;
//             }
//         }

//         return uniqueIndex;
//     }
// }

