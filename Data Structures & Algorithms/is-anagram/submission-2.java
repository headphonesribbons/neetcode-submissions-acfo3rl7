class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) { // not the same length
            return false; // can't be anagrams!
        }
        HashMap<String, Integer> sChar = new HashMap<>();
        HashMap<String, Integer> tChar = new HashMap<>();
        int i = 0;
        while (i < s.length()) {
            String scurr = String.valueOf(s.charAt(i));
            String tcurr = String.valueOf(t.charAt(i));
            if (sChar.containsKey(scurr)) {
                sChar.replace(scurr, sChar.get(scurr) + 1);
            } else {
                sChar.put(scurr, 1);
            }
            if (tChar.containsKey(tcurr)) {
                tChar.replace(tcurr, tChar.get(tcurr) + 1);
            } else {
                tChar.put(tcurr, 1);
            }
            i++;
        }
        return sChar.equals(tChar);
    }
}
