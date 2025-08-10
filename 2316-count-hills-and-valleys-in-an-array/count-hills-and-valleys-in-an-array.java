class Solution {
    public int countHillValley(int[] nums) {
        // Step 1: Remove consecutive duplicates into a temp array
        int n = nums.length;
        int[] arr = new int[n];
        int idx = 0;
        arr[idx++] = nums[0];
        
        for (int i = 1; i < n; i++) {
            if (nums[i] != arr[idx - 1]) {
                arr[idx++] = nums[i];
            }
        }
        
        // Step 2: Count hills and valleys
        int count = 0;
        for (int i = 1; i < idx - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                count++; // Hill
            } else if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                count++; // Valley
            }
        }
        
        return count;
    }
}
