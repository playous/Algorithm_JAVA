import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] alphabet = new int['Z' - 'A' + 1];
        List<Integer> list = new ArrayList<>();
        
        for (String s : keymap){
            char[] ch = s.toCharArray();
            for (int i = 0 ; i < ch.length ; i++){
                int a = ch[i] - 'A';
                if(alphabet[a] == 0 || alphabet[a] > i ) alphabet[a] = i + 1;
            }
        }
        for (String s : targets){
            char[] ch = s.toCharArray();
            int sum = 0;
            boolean flag = true;
            for (int i = 0 ; i < ch.length; i++){
                if (alphabet[ch[i] - 'A'] == 0) flag = false;
                sum += alphabet[ch[i] - 'A'];
            }
            if (flag)list.add(sum);
            else list.add(-1);
        }
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}