class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counts = new HashMap<>(); // frequency map
        Integer[] uniques = new Integer[nums.length]; // no. of uniques: O(n)
        // treat these as the keys later
        int u = 0; // to traverse in uniques array
        for (int i = 0; i < nums.length; i++) { // traverse thru nums
            if (!counts.containsKey(nums[i])) { // if not already in the map,
                counts.put(nums[i], 1); // add it, with the inital count 1
                uniques[u] = nums[i]; // this is a unique key, we shld remember it
                u++;
            } else { // or else its already in the map,
                counts.replace(nums[i], counts.get(nums[i]) + 1); // increment the count.
                // we've seen this key before so it's all good!
            }
        } // we have the completed map!
        List<Integer>[] frequencies = new List[nums.length + 1]; // index: frequency, value: list of indexes with that freq
        // freq = O(n)
        Integer max = 0; // to keep track of the max freq
        for (int j = 0; j < nums.length; j++) { // traverse thru uniques
            if (counts.get(uniques[j]) != null) { // if there is an entry,
                Integer freq = counts.get(uniques[j]); // get the frequency associated w the number
                max = freq > max ? freq : max; // if the frequency found is larger than the current max, update the max
                if (frequencies[freq] == null) { // if no list is in the frequency table,
                    List<Integer> list = new ArrayList<>(); // create one.
                    list.add(uniques[j]); // append the number to the list,
                    frequencies[freq] = list; // then put it into the frequency table.
                } else { // or else we've seen this before
                    List<Integer> list = frequencies[freq]; // just obtain the list currently in the table,
                    list.add(uniques[j]); // append the number to the list,
                    frequencies[freq] = list; // then put it back into the frequency table.
                }
            } // else there's no entry. skip this iteration, go to the next.
        }
        int f = max; // we won't need to traverse thru the whole list. we jst need to check the index max and those smaller than it.
        int[] answer = new int[k]; // the answer array contains k elements
        int a = 0; // to traverse and fill answer array
        while (a < k) { 
            if (frequencies[f] != null) { // if there is an entry in the frequency table,
                for (int l = 0; l < frequencies[f].size(); l++) { // traverse thru the list at that frequency.
                    answer[a] = frequencies[f].get(l); // for each unique number in the list, put it into the array
                    a++;
                }
            }
            f--; // check the smaller frequencies in the freq table.
        }
        return answer;
    }
}
