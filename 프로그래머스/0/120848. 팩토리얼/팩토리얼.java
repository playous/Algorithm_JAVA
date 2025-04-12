import java.util.*;

class Solution {
    public int solution(int n) {
        int result = 1;
        int factorial = 1;
        for (int i = 1 ; i <= 10 ; i ++){
            factorial *= i;
            if (factorial > n) break;
            result = i ;
    
        }
        return result;
    }
}