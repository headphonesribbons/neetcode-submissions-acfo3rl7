class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        List[] keys = new List[len]; // keys for later
        HashMap<List<String>, List<String>> anagrams = new HashMap<>(); // for checking anagrams
        for (int i = 0; i < len; i++) { // traverse array
            String word = strs[i];
            int[] letters = new int[26]; // alphabet array
            for (int j = 0; j < word.length(); j++) { // to make freq array for string
                int letter = word.charAt(j) - 'a';
                letters[letter]++;
            }
            List<String> key = new ArrayList<>(); // make the key
            for (int k = 0; k < 26; k++) { // to make key, we create the sorted letters
                if (letters[k] != 0) { // if this letter exists,
                    while (letters[k] > 0) { // add it all.
                        key.add(String.valueOf(k));
                        letters[k]--;
                    }
                }
            }
            if (anagrams.containsKey(key)) { // if this is an anagram of something we've seen,
                List<String> list = anagrams.get(key);
                list.add(word); // append the curr string to our list
                anagrams.replace(key, list);
            } else { // this is a new thing!
                List<String> list = new ArrayList<>(); // create a new list
                list.add(word); // append the curr string to that list
                anagrams.put(key, list); // put it into the map
                keys[i] = key;
            }
        }
        List<List<String>> answer = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (keys[i] != null) {
                List<String> key = keys[i];
                List<String> words = anagrams.get(key);
                answer.add(words);
            }
        }
        return answer;
    }
}
