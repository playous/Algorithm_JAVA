import java.util.*;

class Solution {
    
    int n;
    int[] cards;
    boolean[] visited;
    List<Integer> list;

    public int solution(int[] cards) {
        
        this.cards = cards;
        
        list = new ArrayList<>();
        
        n = cards.length;
        
        visited = new boolean[n];
        
        for (int i = 0 ; i < n ; i ++){
            if (!visited[i]){
                int size = calc(i);
                list.add(size);
            }
        }
        
        list.sort(Collections.reverseOrder());
        
        int answer = 0;
        
        if (list.size() != 1) answer = list.get(0) * list.get(1);
        
        return answer;
    }
    
    public int calc(int idx){
        int cur = idx;
        
        int count = 0;
        int next = 0;
        
        while (true){
            visited[cur] = true;
            count++;
            
            next = cards[cur] - 1;
            
            if (visited[next]) break;
            
            cur = next;
        }
        
        return count;
    }
}