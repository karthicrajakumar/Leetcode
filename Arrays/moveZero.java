// Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Example:

// Input: [0,1,0,3,12]
// Output: [1,3,12,0,0]

class Solution {
    public void moveZeroes(int[] nums) {
        int i =0;
        int j = 1;
        int count = 0;
        while( count <nums.length-1){
            while(nums[i] != 0 && i < nums.length-1)
                i++;
            while(nums[j] ==0 && j < nums.length-1)
                j++;
            if(nums[i] == 0 && i <j){

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }else
                j++;
            count++;

        }
    }
}
