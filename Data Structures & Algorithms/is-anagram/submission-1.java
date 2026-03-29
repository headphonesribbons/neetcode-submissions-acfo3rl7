class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sArray = new int[256];
        int[] tArray = new int[256];
        if (s.length() != t.length()) { // not the same length
            return false; // can't be anagrams!
        }
        for (int i = 0; i < s.length(); i++) { // s and t are the same length, can share same loop
            int sIndex = (int) s.charAt(i); // get the corresponding index of this char
            sArray[sIndex]++; // increment that by one, since we've seen this letter once more than we did before
            int tIndex = (int) t.charAt(i); // ditto
            tArray[tIndex]++;
        } 
        boolean b = true;
        for (int i = 0; i < 256; i++) {
            if (sArray[i] != tArray[i]) { // woah that's different!
                b = false; // def NOT anagrams
                break; // don't need to check the rest
            } // else we haven't found a difference, lets keep going
        } // they match! b remains true
        return b;
    }
}
