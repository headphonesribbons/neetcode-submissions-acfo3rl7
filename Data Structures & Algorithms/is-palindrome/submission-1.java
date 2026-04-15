class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            int left_char = s.charAt(left); // working w ints makes my life easier
            int right_char = s.charAt(right);
            boolean left_validity = true;
            boolean right_validity = true;
            if (left_char <= 122 && left_char >= 97) { // if left is lowercase,
                left_char = left_char - 32; // change to upper case
            } 
            if (right_char <= 122 && right_char >= 97) { // if right is lowercase,
                right_char = right_char - 32; // change to upper case
            }
            if (left_char > 90 || left_char < 65) { // left is not a letter,
                left_validity = left_char >= 48 && left_char <= 57;
                if (!left_validity) {
                    left++;
                }
            }
            if (right_char > 90 || right_char < 65) { // ditto
                right_validity = right_char >= 48 && right_char <= 57;
                if (!right_validity) {
                    right--;
                }
            } 
            if (left_validity && right_validity) {
                if (left_char != right_char) {
                    return false;
                }
                left++;
                right--;
            } 
        }
        return true;
    }
}
