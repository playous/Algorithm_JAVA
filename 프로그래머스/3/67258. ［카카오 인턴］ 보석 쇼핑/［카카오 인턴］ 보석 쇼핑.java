import java.util.*;

class Solution {
    
    class Node{
        int idx;
        String name;
        Node(int idx, String name){
            this.idx = idx;
            this.name = name;
        }
    }
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0 ; i < gems.length; i ++){
            set.add(gems[i]);
            map.put(gems[i], 0);
        }
        
        int count = set.size();
        
        int curCount = 0;
        
        int minLen = 10000000;
        
        Queue<Node> q = new ArrayDeque<>();
        
        
        for (int i = 0 ; i < gems.length ; i ++){
            q.add(new Node(i, gems[i]));            
            map.put(gems[i], map.get(gems[i]) + 1);
            if (map.get(gems[i]) == 1) curCount++;
            if (map.get(gems[i]) == 0) curCount--;
            
            while(true){
                if(map.get(q.peek().name) > 1){
                    String top = q.peek().name;
                    map.put(top, map.get(top) - 1);
                    q.poll();
                }
                else break;
            }
                        
            if (curCount == count){
                int curLen = i - q.peek().idx + 1;
                if (curLen < minLen){
                    answer[0] = q.peek().idx + 1;
                    answer[1] = i + 1;
                    minLen = curLen;
                }
            }
  
            
        }
        
        return answer;
    }
}