import java.util.*;

class Solution {
    public int solution(int N, int number) {
        Set<Integer>[] set = new HashSet[9];
        
        for (int i = 1 ; i <= 8 ; i ++){
            set[i] = new HashSet<>();
        }
        
        int n = N;
        for (int i = 1; i <= 8 ; i ++){
            set[i].add(n);
            n *= 10;
            n += N;
        }
        
        for (int i = 1; i<= 8; i ++){
            for (int j = 1; j < i ; j++){
                int next = i - j;
                if (next > 8 || next == 0) continue;
                for (int a : set[j]){
                    for (int b : set[i-j]){
                        set[i].add(a + b);
                        set[i].add(a - b);
                        set[i].add(a * b);
                        if (b != 0) set[i].add(a / b);
                    }
                }
            }
            if (set[i].contains(number)){
                return i;
             }
        }
    
        return -1;
    }
}