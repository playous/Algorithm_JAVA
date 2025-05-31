import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) { 
        int answer = 0;
        for (String s : skill_trees){
            Queue<Character> q = new LinkedList<>();
            char[] ch = skill.toCharArray();
            for (char c : ch){
                q.add(c);
            }
            char[] tree = s.toCharArray();
            for (char c : tree){
                if(q.peek() == c) q.poll();
                if(q.isEmpty()) break;
            }
            if (q.isEmpty()){
                answer ++;
            } 
            else {
                boolean flag = true;
                while(!q.isEmpty()){
                    if (s.indexOf(q.poll()) != -1) flag = false;
                }
                if (flag) answer++;
            }
        }
        return answer;
    }
}