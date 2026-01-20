import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        int[] arr = new int[n * 2 + 1];
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n * 2; i++) {
            arr[i + 1] = arr[i] + elements[i % n];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = arr[i + j] - arr[j];
                set.add(sum);
            }
        }

        return set.size() + 1; 
    }
}