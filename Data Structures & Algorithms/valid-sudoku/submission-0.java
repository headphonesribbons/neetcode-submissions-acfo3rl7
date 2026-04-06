class Solution {
    public boolean isValidSudoku(char[][] board) {
        // hashmap, key: digit, value: list of points with that value
        HashMap<String, List<Pair<Integer, Integer>>> grid = new HashMap<>();
        HashMap<Pair<Integer, Integer>, List<String>> my3x3s = new HashMap<>();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                String element = String.valueOf(board[r][c]); // curr element
                if (element.equals(String.valueOf('.'))) {
                    continue;
                }
                if (grid.containsKey(element)) { // if this element has been seen,
                    List<Pair<Integer, Integer>> points = grid.get(element); // get the value currently mapped to it
                    for (int l = 0; l < points.size(); l++) { // for every point with this element,
                        Pair<Integer, Integer> point = points.get(l); 
                        if (point.getKey() == r || point.getValue() == c) { // if either their row or col is the same as the curr,
                            return false; // this is invalid. we found a dupe in the same lane
                        } 
                    } // else this is the only one in its row and its col,
                    points.add(new Pair<>(r, c)); // append to the list of points,
                    grid.put(element, points); // put it back into the hashmap
                } else { // it hasn't been seen, 
                    List<Pair<Integer, Integer>> points = new ArrayList<Pair<Integer, Integer>>(List.of(new Pair<Integer, Integer>(r, c))); // make a new list to store this value,
                    grid.put(element, points); // put it into the hashmap.
                }
                // check 3x3s
                    // create a larger "grid" with each 3x3 rep by one point.
                // this element is currently in:
                Pair<Integer, Integer> ts3x3 = new Pair<>(r / 3, c / 3);
                if (my3x3s.containsKey(ts3x3)) { // if we've initialised this grid,
                    List<String> elems = my3x3s.get(ts3x3); // get the digits in this grid
                    for (int l = 0; l < elems.size(); l++) { // for every digit,
                        String curr = elems.get(l); 
                        if (curr.equals(element)) { // if there is a dupe,
                            return false; // return false
                        }
                    } // or else no dupe,
                    elems.add(element); // add it
                    my3x3s.put(ts3x3, elems); // put it into my3x3 hashmap
                } else { // else we haven't seen any digit in this grid,
                    List<String> elems = new ArrayList<String>(List.of(element)); // create a list to store this value,
                    my3x3s.put(ts3x3, elems); // put it into my3x3 hashmap.
                }
            }
        }
        return true;
    }
}
