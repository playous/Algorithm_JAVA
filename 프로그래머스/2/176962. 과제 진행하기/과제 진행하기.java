import java.util.*;

class Solution {
    static class Node {
        String name;
        int start;
        int remain;
        Node(String name, int start, int remain){
            this.name = name;
            this.start = start;
            this.remain = remain;
        }
    }
    public String[] solution(String[][] plans) {
      
        List<Node> list = new ArrayList<>();
        
        int n = plans.length;
        
        String[] answer = new String[n];
        
        for (int i = 0 ; i < n ; i ++){
            String name = plans[i][0];
            int start = change(plans[i][1]);
            int remain = Integer.parseInt(plans[i][2]);
            
            list.add(new Node(name, start, remain));
        }
        
        int idx = 0;
        
        list.sort((a, b) -> a.start - b.start);
        
        Stack<Node> stack = new Stack<>();
        
        for (int i = 0 ; i < list.size() - 1; i ++){
            Node cur = list.get(i);
            Node next = list.get(i + 1);
            
            int max = next.start - cur.start;
            
            if(cur.remain <= max){
                answer[idx++] = cur.name;
                int time = max - cur.remain;
                
                while (time > 0){
                    if (!stack.isEmpty()){
                        Node c = stack.pop();
                        if (c.remain <= time){
                            answer[idx++] = c.name;
                            time -= c.remain;
                        }
                        else {
                            stack.push(new Node(c.name, c.start, c.remain - time));
                            break;
                        }
                    }
                    else break;
                 }
            }
            else {
                stack.add(new Node(cur.name, cur.start, cur.remain - max));
            }
        }
        
        answer[idx++] = list.get(n-1).name;
        
        while (!stack.isEmpty()){
            answer[idx++] = stack.pop().name;
        }
        
        return answer;
    }
    
    public int change (String s){
        String[] arr = s.split(":");
        return (Integer.parseInt(arr[0]) * 60) + Integer.parseInt(arr[1]);
    }
}