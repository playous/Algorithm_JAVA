import java.util.*;

class Solution {
    public int[] solution(String my_string) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        for (char c : my_string.toCharArray()){
            if(c >= '0' && c <= '9')
                arr.add(c - '0');
        }

        int[] answer = new int[arr.size()];
        
        for (int i = 0 ; i < arr.size(); i++){
            answer[i] = arr.get(i);
        }
        Arrays.sort(answer);
        
        return answer;
    }
}