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
        
        long maxSum = arr1[0];
        long cur = arr1[0];
        
        for (int i = 1; i < n; i++) {
            cur = Math.max(arr1[i], cur + arr1[i]);
            maxSum = Math.max(maxSum, cur);
        }
        
        long maxSum2 = arr2[0];
        long cur2 = arr2[0];
        
        for (int i = 1; i < n; i++) {
            cur2 = Math.max(arr2[i], cur2 + arr2[i]);
            maxSum2 = Math.max(maxSum2, cur2);
        }
      
        return Math.max(maxSum, maxSum2);
    }
}