class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) { // run thru array
            int remainder = target - nums[i]; // if we find an answer, we can terminate early
            if (map.containsKey(remainder)) { // we've already found a pair
                answer[0] = map.get(remainder);
                answer[1] = i;
                break;
            }
            map.put(nums[i], i); // put elements into hashmap and correspond to index
        }
        return answer;
    }
}
