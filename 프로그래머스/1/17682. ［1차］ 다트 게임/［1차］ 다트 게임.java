import java.util.*;
import java.io.*;

class Solution {
    public int solution(String dartResult) {
        char[] arr = dartResult.toCharArray();
        
        Stack<Integer> q = new Stack<>();
        int idx = 0;
        if (arr[0] == '1' && arr[1] == '0'){
            q.add(10);
            idx = 2;
        }
        else {
            q.add(arr[0] - '0');
            idx = 1;
        }
    
        
        while (!q.isEmpty() && idx < arr.length){
            char cur = arr[idx++];
            if (cur - '0' >= 0 && cur - '0' <= 9){
                if (idx < arr.length && cur == '1' && arr[idx] == '0'){
                    q.add(10);
                    idx++;
                }
                else q.add(cur - '0');
            }
            else {
                int top = q.pop();
                if (cur == 'S'){
                    q.add(top);
                }
                else if (cur == 'D'){
                    q.add(top * top);
                }
                else if (cur == 'T'){
                    q.add(top * top * top);
                }
                else if (cur == '*'){
                    if (q.isEmpty()){
                        q.add(top * 2);
                    }
                    else {
                        int prev = q.pop();
                        q.add(prev * 2);
                        q.add(top * 2);
                    }
                }
                else if (cur == '#'){
                    q.add(top * -1);
                }
            }
        }
        
        int answer = 0;
        for (int n : q){
            answer += n;
        }
        return answer;
    }
}