import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        
        HashSet<Integer>[] set = new HashSet[9];
        
        int num = N;
        
        for (int i = 1 ; i <= 8 ; i ++){
            set[i] = new HashSet<>();
            set[i].add(num);
            num *= 10;
            num += N;
        }
                
        if (N == number) return 1;
        
        for (int i = 2; i <= 8 ; i ++){
            
            for (int j = 1 ; j < i ; j++){
                int left = j;
                int right = i - j;
                
                for (int num1 : set[left]){
                    for (int num2 : set[right]){
                        set[i].add(num1 + num2);
                        set[i].add(num1 - num2);
                        set[i].add(num1 * num2);
                        if (num2 != 0) set[i].add(num1/num2);
                    }
                }    
            
            }
            if (set[i].contains(number)){
                answer = i;
                break;
            }
        }
      
        return answer;
    }
}