import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] prime = new int[10001];
        ArrayList<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        
        prime[0] = prime[1] = 1; 
      
        for (int i = 2; i <= Math.sqrt(10001) ; i++){
            if(prime[i] == 0){
                for (int j = i * i ; j <= 10000 ; j += i){
                    prime[j] = 1;
                }
            }
        }
       
        for (int i = 2 ; i < 10001 ; i ++){
            if(prime[i] == 0) list.add(i);
        }
        
        for(int i : list){
            while(n % i == 0){
                n /= i;
                set.add(i);
            }
        }
        
        int[] answer = new int[set.size()];
        int index = 0;
        
        for(int i : set){
            answer[index++] = i;
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}