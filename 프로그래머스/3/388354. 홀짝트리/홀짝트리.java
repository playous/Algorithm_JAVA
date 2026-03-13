import java.util.*;

class Solution {
    
    public Set<Integer> set = new HashSet<>();
    
    public int[] nodes;
    public HashMap<Integer, List<Integer>> map = new HashMap<>();
    
    // 홀짝
    int answer1 = 0;
    
    // 역홀짝
    int answer2 = 0;
   
    public int[] solution(int[] nodes, int[][] edges) {
        
        this.nodes = nodes;
                
        for (int i = 0 ; i < nodes.length; i ++){
            List<Integer> sub = new ArrayList<>();
            map.put(nodes[i], sub);
            set.add(nodes[i]);
        }
        
        for (int i = 0; i < edges.length; i ++){
            int a = edges[i][0];
            int b = edges[i][1];
            
            List<Integer> al = map.get(a);
            List<Integer> bl = map.get(b);
            
            al.add(b);
            bl.add(a);
            
            map.put(a, al);
            map.put(b, bl);
        }
        for (int i = 0 ; i < nodes.length; i ++){
            if(set.contains(nodes[i])){
                bfs(nodes[i]);
            }
        }
        
        int[] answer = new int[2];
        answer[0] = answer1;
        answer[1] = answer2;
        
        return answer;
    }
    
    public void bfs(int i){
        int same = 0;
        int notSame = 0;
        
        Queue<Integer> q = new ArrayDeque<>();
        
        q.add(i);
        set.remove(i);
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            List<Integer> child = map.get(cur);
            
            int childCnt = child.size();
            
            if (cur % 2 == 0){
                if (childCnt % 2 == 0) same++;
                else notSame++;
            }
            else {
                if (childCnt % 2 == 1) same++;
                else notSame++;
            }
            
            for (int next : child){
                if (set.contains(next)){
                    set.remove(next);
                    q.add(next);
                }
            }
        }
        
        if (same == 1) answer1++;
        if (notSame == 1) answer2++;
            
    }
}