import java.util.*;

class Solution {
    String[] answer = {};
    String[][] tickets;
    boolean find;
    boolean[] visited;
    int len = 0;
    
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        
        len = tickets.length;
        visited = new boolean[len];
        
        calc(0, "ICN", "ICN");
        
        return answer;
    }
    
    public void calc(int cnt, String str, String next){
        if (find) return;
        if (cnt == len){
            answer = str.split(" ");
            find = true;
            return;
        } 
        
        for (int i = 0 ; i < len ; i ++){
            String a = tickets[i][0];
            String b = tickets[i][1];
            
            if (a.equals(next) && !visited[i]){
                visited[i] = true;
                calc(cnt + 1, str + " " + b, b);
                visited[i] = false;
            }
        }
    }
}