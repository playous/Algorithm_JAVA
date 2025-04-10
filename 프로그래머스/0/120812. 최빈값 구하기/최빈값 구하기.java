import java.util.*;

class Solution {
    public int solution(int[] array) {
        if(array.length == 1) return array[0];
        
        int[] sum = new int[1000];
        int answer = 0;
        int max = 1;
        boolean check = true;

        for (int n : array){
            sum[n]++;
        }
        for (int i = 0 ; i < 1000 ; i ++){
            if(sum[i] == 0) continue;
            if(sum[i] > max) {
                answer = i;
                max = sum[i];
                check = false;
            }
            else if (sum[i] == max){
                check = true;
            }
        }
        if(check) return -1;
        else return answer;
    }
}