class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length]; 
        for (int i = 0; i < nums.length; i++) { // "self"
            int j = 0; // not "self"
            int product = 1; 
            while (j < nums.length) {
                if (j == i) {
                    j++;
                } else {
                    product = product * nums[j];
                    j++;
                }
            }
            answer[i] = product;
        }
        return answer;
    }
}  
