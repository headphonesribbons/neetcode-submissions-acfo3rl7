class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // key: value; value: index
        int i = 0;
        int[] answer = new int[2];
        while (i < numbers.length) {
            int remainder = target - numbers[i];
            if (map.containsKey(remainder)) {
                answer[0] = map.get(remainder) + 1;
                answer[1] = i + 1;
                break;
            }
            map.put(numbers[i], i);
            i++;
        }
        return answer;
    }
}
