import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        Integer[] boxedArray = Arrays.stream(numlist).boxed().toArray(Integer[]::new);
        
        Arrays.sort(boxedArray, (a, b) -> {
            int diffA = Math.abs(a - n);
            int diffB = Math.abs(b - n);
            if (diffA == diffB) {
                return b - a; 
            }
            return diffA - diffB;
        });
        
        return Arrays.stream(boxedArray).mapToInt(Integer::intValue).toArray();
    }
}