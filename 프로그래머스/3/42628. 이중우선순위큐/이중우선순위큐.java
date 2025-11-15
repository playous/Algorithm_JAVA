import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (String op : operations) {
            String[] parts = op.split(" ");
            String command = parts[0];
            int number = Integer.parseInt(parts[1]);

            if (command.equals("I")) {
                map.put(number, map.getOrDefault(number, 0) + 1);
            } 
            else if (command.equals("D") && !map.isEmpty()) {
                if (number == 1) { 
                    int maxKey = map.lastKey(); 
                    int count = map.get(maxKey);
                    if (count == 1) {
                        map.remove(maxKey); 
                    } else {
                        map.put(maxKey, count - 1); 
                    }
                } else { 
                    int minKey = map.firstKey(); 
                    int count = map.get(minKey);
                    if (count == 1) {
                        map.remove(minKey);
                    } else {
                        map.put(minKey, count - 1);
                    }
                }
            }
        }

        if (map.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{map.lastKey(), map.firstKey()};
        }
    }
}