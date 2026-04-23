class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // try two pointers
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int total = numbers[left] + numbers[right];
            if (total > target) {
                right--;
                continue;
            } 
            if (total < target) {
                left++;
                continue;
            }
            if (total == target) {
                break;
            }
        }
        return new int[] {left + 1, right + 1};
    }
}
