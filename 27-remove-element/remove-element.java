class Solution {
    public int removeElement(int[] nums, int val) {
         int k = 0; // pointer for the next position to insert non-val elements

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i]; // copy only if the element is not equal to val
                k++;
            }
        }

        return k;
    }
}