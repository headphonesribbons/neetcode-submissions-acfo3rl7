class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) { // run thru array
            int remainder = target - nums[i]; // if we find an answer, we can terminate early
            if (map.containsValue(remainder)) { // we've already found a pair
                for (int j = 0; j < i; j++) { // find the index of the smaller number
                    if (remainder == nums[j]) {
                        answer[0] = j;
                        answer[1] = i;
                        break;
                    }
                }
                break;
            }
            map.put(i, nums[i]); // put elements into hashmap and correspond to index
        }
        return answer;
    }
}
