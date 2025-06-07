class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 =0;
        int count2= 0;
        Integer element1 = null;
        Integer element2= null;
        for(int i=0; i<nums.length ;i++){
            if (element1 != null && nums[i] == element1) {
                count1++;
            } else if (element2 != null && nums[i] == element2) {
                count2++;
            } else if (count1 == 0) {
                count1 = 1;
                element1 = nums[i];
            } else if (count2 == 0) {
                count2 = 1;
                element2 = nums[i];
            } else {
                count1--;
                count2--;
            }
        }
         count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (element1 != null && num == element1) count1++;
            else if (element2 != null && num == element2) count2++;
        }

        List<Integer> result = new ArrayList<>();
        if (count1 > nums.length / 3) result.add(element1);
        if (count2 > nums.length / 3) result.add(element2);

        return result;

    }
}