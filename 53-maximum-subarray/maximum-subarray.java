class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = nums[0];
        for(int i =1; i<nums.length ;i++){
            sum+= nums[i];
            sum =Math.max(sum, nums[i]);
            maxSum= Math.max(sum, maxSum);
        }
        return maxSum;
    }
}