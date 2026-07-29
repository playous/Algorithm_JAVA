import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 1 ; i <= n ; i ++){
            for (int j = 0; j < n ; j ++){
                int sum = 0;
                for (int q = j; q < i + j ; q ++){
                    sum += elements[q % n];
                } 
                set.add(sum);
            }
        }
        return set.size();
        
    }
}