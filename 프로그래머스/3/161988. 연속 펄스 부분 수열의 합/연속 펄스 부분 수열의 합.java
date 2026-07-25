import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int n = sequence.length;
        
        int[] arr1 = sequence.clone();
        int[] arr2 = sequence.clone();
        
        for (int i = 0 ; i < n ; i ++){
            if (i % 2 == 0){
                arr1[i] *= -1;
            }
            else {
                arr2[i] *= -1;
            }
        }
        
        long maxSum1 = arr1[0];
        long answer1 = arr1[0];
        
        for (int i = 1; i < n ; i ++){
            maxSum1 = Math.max(maxSum1 + arr1[i], arr1[i]);
            answer1 = Math.max(answer1, maxSum1);
        }
        
        long maxSum2 = arr2[0];
        long answer2 = arr2[0];
        
        for (int i = 1; i < n ; i ++){
            maxSum2 = Math.max(maxSum2 + arr2[i], arr2[i]);
            answer2 = Math.max(answer2, maxSum2);
        }
      
        return Math.max(answer1, answer2);
    }
}