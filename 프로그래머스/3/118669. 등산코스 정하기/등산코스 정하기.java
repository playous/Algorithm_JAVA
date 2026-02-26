import java.util.*;

class Solution {
    
    class Node{
        int e;
        int w;
        Node(int e, int w){
            this.e = e;
            this.w = w;
        }
    }
    
    class Node1{
        int e;
        int w;
        int maxW;
        Node1(int e, int w, int maxW){
            this.e = e;
            this.w = w;
            this.maxW = maxW;
        }
    }
    
    List<Node>[] graph;
    HashSet<Integer> set;
    
    int answerTarget = Integer.MAX_VALUE;
    int intensity = Integer.MAX_VALUE;
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
      
        graph = new List[n + 1];
        set = new HashSet<>();
        
        for (int target : summits){
            set.add(target);
        }
        
        for (int i = 1 ; i <= n ; i ++){
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0 ; i < paths.length; i ++){
            int s = paths[i][0];
            int e = paths[i][1];
            int w = paths[i][2];
            
            graph[s].add(new Node(e, w));
            graph[e].add(new Node(s, w));
        }
        
        for (int start : gates){
            PriorityQueue<Node1> pq = new PriorityQueue<>((a,b) -> a.w - b.w);
            
            int[] visited = new int[n + 1];
            
            Arrays.fill(visited, Integer.MAX_VALUE);
            
            visited[start] = 0;
            
            for (Node next : graph[start]){
                int nName = next.e;
                int weight = next.w;
                visited[nName] = weight;
                
                if (set.contains(nName)){
                    if(intensity == weight){
                        answerTarget = Math.min(nName, answerTarget);
                    }
                    if(intensity > weight){
                        answerTarget = nName;
                        intensity = weight;
                    }
                }

                pq.add(new Node1(nName, weight, weight));
            }
            
            
            while(!pq.isEmpty()){
                Node1 cur = pq.poll();
                int name = cur.e;
                int weight = cur.w;
                int max = cur.maxW;

                if (max > intensity) continue;
                
                if (set.contains(name)){
                    if(intensity == max){
                        answerTarget = Math.min(name, answerTarget);
                    }
                    if(intensity > max){
                        answerTarget = name;
                        intensity = max;
                    }
                    continue;
   
                }
            

                for (Node next : graph[name]){
                    int nName = next.e;
                    int nWeight = next.w;
                    int newMax = Math.max(nWeight, max);
                    
                    if (visited[nName] > nWeight) {
                        visited[nName] = nWeight;
                        pq.add(new Node1(nName, nWeight, newMax));
                    }
                }
                
            }
        }
        
        int[] answer = new int[2];
        
        answer[0] = answerTarget;
        answer[1] = intensity;
        
        return answer;
    }
}