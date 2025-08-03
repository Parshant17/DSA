public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int index = 2; // Start placing from the third position

        for (int i = 2; i < nums.length; i++) {
            // Compare with the element two places before
            if (nums[i] != nums[index - 2]) {
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }

    // Test the solution
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] nums1 = {1,1,1,2,2,3};
        int k1 = sol.removeDuplicates(nums1);
        System.out.println("k = " + k1);
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + " ");
        }

        System.out.println();

        int[] nums2 = {0,0,1,1,1,1,2,3,3};
        int k2 = sol.removeDuplicates(nums2);
        System.out.println("k = " + k2);
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + " ");
        }
    }
}
