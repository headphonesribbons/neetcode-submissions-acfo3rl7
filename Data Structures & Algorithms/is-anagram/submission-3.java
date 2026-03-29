class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) { // not the same length
            return false; // can't be anagrams!
        }
        HashMap<String, Integer> sChar = new HashMap<>();
        int i = 0;
        while (i < s.length()) {
            String scurr = String.valueOf(s.charAt(i));
            if (sChar.containsKey(scurr)) {
                sChar.replace(scurr, sChar.get(scurr) + 1);
            } else {
                sChar.put(scurr, 1);
            }
            i++;
        }
        boolean b = true;
        int j = 0;
        while (j < t.length()) {
            String tcurr = String.valueOf(t.charAt(j));
            if (!sChar.containsKey(tcurr)) {
                b = false;
                break;
            } else {
                sChar.replace(tcurr, sChar.get(tcurr) - 1);
            }
            j++;
        }
        for (int a = 0; a < s.length(); a++) {
            String scurr = String.valueOf(s.charAt(a));
            b = b && (sChar.get(scurr) == 0);
        }
        return b;
    }
}
