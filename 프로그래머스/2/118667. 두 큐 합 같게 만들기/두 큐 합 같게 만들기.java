import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();

        long sum1 = 0;
        long sum2 = 0;
        
        for (int i = 0; i < queue1.length; i ++){
            sum1 += queue1[i];
            list1.add(queue1[i]);
        }
        
        for (int i = 0; i < queue2.length; i ++){
            sum2 += queue2[i];
            list2.add(queue2[i]);
        }
        
        int answer = 0;
        
        
        while (sum1 != sum2){
            if (sum1 == 0 || sum2 == 0 || answer > 300000){
                answer = -1;
                break;
            }
            if(sum1 < sum2){
                int k = list2.removeFirst();
                list1.add(k);
                sum1 += k;
                sum2 -= k;
            }else{
                int k = list1.removeFirst();
                list2.add(k);
                sum2 += k;
                sum1 -= k;
            }
            answer++;
        }
        return answer;
    }
}