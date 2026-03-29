class Solution {
    /**
     * @param {number[]} nums
     * @return {boolean}
     */
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean b = false;
        int i = 0;
        while (i < nums.length) {
            if (map.containsValue(nums[i])) { // dupe found
                b = true; // yes, hasDuplicate
                break; // don't check for more
            } else { // not a dupe
                map.put(i, nums[i]); // put it in the map!
                i++;
            } 
        } // runs until we finish the array -- b won't update if no dupes
        return b; 
    }
}
