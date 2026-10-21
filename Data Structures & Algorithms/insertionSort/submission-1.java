// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> answer = new ArrayList<>();
        for (int i = 0; i < pairs.size(); i++) {
            Pair curr = pairs.get(i); // our pivot
            int j = i - 1;
            while (j >= 0 && pairs.get(j).key > curr.key) { // for larger prev
                pairs.set(j + 1, pairs.get(j)); // shift the larger to the right
                pairs.set(j, curr); // put curr into the list at j
                j--; // make j smaller
            } // once this while loop ends, one iteration is done
            answer.add(new ArrayList<>(pairs)); // append this iteration
        }
        return answer;
    }
}
