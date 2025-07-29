class Solution {
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
         HashSet<Integer> result = new HashSet<>();
       // int count =0;
        for(int i =0; i < nums1.length; i++){
            set.add(nums1[i]);
        }
        for(int j = 0; j < nums2.length; j++){
            if(set.contains(nums2[j])){
                result.add(nums2[j]); // add to result
                set.remove(nums2[j]); // prevent duplicates
              
            }
        }
        int[] output = new int[result.size()];
        int idx = 0;
        for (int num : result) {
            output[idx++] = num;
        }
        return output;
    }
}