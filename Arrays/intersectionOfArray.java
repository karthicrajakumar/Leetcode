// Given two arrays, write a function to compute their intersection.

// Example 1:

// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2]

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i : nums1){
            set.add(i);
        }
        List<Integer> res = new ArrayList<Integer>();
        for(int i =0 ;i < nums2.length; i++){
            if(set.contains(nums2[i])){
                set.remove(nums2[i]);
                res.add(nums2[i]);
            }
        }
        int[] r = new int[res.size()];
        for(int i =0; i< res.size(); i++){
            r[i] = res.get(i);
        }
        return r;
    }
}
