import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        HashSet<Integer> set = new HashSet<>();
        int zeroCount = 0;
        
        for (int num : win_nums){
            set.add(num);
        }
        for (int i = 0; i < 6; i ++){
            if (lottos[i] == 0) zeroCount++;
            if (set.contains(lottos[i])){
                set.remove(lottos[i]);
            }
        }
        
        int correct = 6 - set.size();
        int maxCorrect = 6 - set.size() + zeroCount;
        System.out.println(correct + " " + maxCorrect);
        
        int[] answer = new int[2];
        answer[1] = 7 - correct <= 6 ? 7 - correct : 6;
        answer[0] = 7 - maxCorrect <= 6 ? 7 - maxCorrect : 6;
        return answer;
    }
}