import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        int n = record.length;
        int cnt = n;
        StringBuilder sb = new StringBuilder();
        
        HashMap<String, String> map = new HashMap<>();
        
        for (int i = 0 ; i < n ; i++){
            String[] s = record[i].split(" ");
            if(s[0].equals("Enter")) {
                map.put(s[1], s[2]);
            }
            if (s[0].equals("Change")){
                map.put(s[1], s[2]);
                cnt--;
            }
        }
        
        String[] answer = new String[cnt];
        int idx = 0;
        
        for (int i = 0 ; i < n ; i ++){
            sb = new StringBuilder();
            String[] s = record[i].split(" ");
            if(s[0].equals("Enter")) {
                sb.append(map.get(s[1])).append("님이 들어왔습니다.");
                answer[idx++] = sb.toString();
            }
            if (s[0].equals("Leave")){
                sb.append(map.get(s[1])).append("님이 나갔습니다."); 
                answer[idx++] = sb.toString();
            }
        }
        
        
        return answer;
    }
}