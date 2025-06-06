class Solution {
    public int removeDuplicates(int[] nums) {
        // maintain two pointer
        //1. writer pointer (it will kepp when reader and writer value are not same )
      int writer =0 ;
      //read pointer keep moving
        for( int reader = 1; reader<nums.length;reader++){
            if(nums[writer]!= nums [reader]){
                writer++;
                nums[writer] = nums[reader];
            }
        }
        return writer + 1;

    }
}