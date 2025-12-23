import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        int ansIdx = 0;
        int len = words.length;
        
        Set<String> set = new HashSet<>();
        
        set.add(words[0]);
        String last = words[0].substring(words[0].length() - 1, words[0].length());
        for (int i = 1; i < len ; i ++){
            String first = words[i].substring(0, 1);
            if(!last.equals(first) || set.contains(words[i])){
                ansIdx = i + 1;
                break;
            }
            last = words[i].substring(words[i].length() - 1, words[i].length());
            set.add(words[i]);
        }
        
        if (ansIdx == 0){
            answer[0] = 0;
            answer[1] = 0;
        }
        else {
            answer[0] = ansIdx % n == 0 ? n : ansIdx % n;
            answer[1] = ansIdx / n;
            if (ansIdx % n != 0){
                answer[1]++;
            }
        }
        
        return answer;
    }
}