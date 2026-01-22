import java.util.*;
import java.io.*;

class Solution {
    static int len, len2;
    static int answerPlus, answerSum;
    
    static int[][] users;
    static int[] emoticons;
    
    static int[] sale;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        
        Arrays.sort(users, (a, b) -> b[0] - a[0]);
        len = users.length;
        len2 = emoticons.length;
   
        this.users = users;
        this.emoticons = emoticons;
        
        answerPlus = 0;
        answerSum = 0;
        
        sale = new int[len2];
        
        dfs(0);
        
        answer[0] = answerPlus;
        answer[1] = answerSum;
        
        return answer;
    }
    
    public static void dfs(int idx){
        if (idx == len2){
            calc();
            return;
        }
        for (int i = 40; i >= 10 ; i -= 10){
            sale[idx] = i;
            dfs(idx + 1);
        } 
    }
    
    public static void calc(){
        int plus = 0;
        int sum = 0;
        for (int i = 0; i < len ; i ++){
            if (answerPlus > plus + len - i) break;
            int max = users[i][0];
            int money = users[i][1];
            int sum1 = 0;
            for (int j = 0 ; j < emoticons.length ; j ++){
                if (max <= sale[j]){
                    sum1 += (emoticons[j] * (100 - sale[j]))/ 100; 
                }
            }
            if (sum1 >= money) plus++;
            else sum += sum1;
        }
        if (plus > answerPlus){
            answerPlus = plus;
            answerSum = sum;
        }
        else if (plus == answerPlus){
            if (answerSum < sum){
                answerSum = sum;
            }
        }
    }
}