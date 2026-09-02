import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        int len1 = queue1.length;
        int len2 = queue2.length;
        
        long sum1 = 0;
        long sum2 = 0;
        
        for (int n : queue1){
            sum1 += n;
        }
        
        for (int n : queue2){
            sum2 += n;
        }
        
        int len = len1 + len2;
        
        int[] arr = new int[len];
        
        for (int i = 0; i < len1 ; i++){
            arr[i] = queue1[i];
        }
        for (int i = 0; i < len2 ; i++){
            arr[i + len1] = queue2[i];
        }
        
        int left = 0;
        int right = len1;
        
        boolean flag = false;
        
        while (right < len){
            if(sum1 == sum2){
                flag = true;
                break;
            }
            
            int q1 = arr[left];
            int q2 = arr[right];
            
            if (sum1 < sum2){
                sum1 += q2;
                sum2 -= q2;
                right++;
            }
            else if (sum1 > sum2){
                sum1 -= q1;
                sum2 += q1;
                left++;
            }
            answer++;
        }
        
        if (!flag) answer = -1;
        return answer;
        
    }
}