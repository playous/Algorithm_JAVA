import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        int[] answer = new int[n]; // 다음달의 받을 선물 수
        int[] gift = new int[n]; // 선물 지수
        int maxGift = 0;
        
        int[][] arr  = new int[n][n];
        HashMap<String,Integer> map = new HashMap<>();
        
        for (int i = 0; i < n ; i++){
            map.put(friends[i],i);
        }
        
        for (int i = 0; i < gifts.length; i ++){
            String[] st = gifts[i].split(" ");
            int a = map.get(st[0]);
            int b = map.get(st[1]);
            gift[a]++;
            gift[b]--;
            arr[a][b] += 1;
        }
        
        for (int i = 0 ; i < n ; i ++){
            for (int j = 0; j < n && i != j ; j ++){
                if (arr[i][j] > arr[j][i]) answer[i]++;
                if (arr[i][j] < arr[j][i]) answer[j]++;
                if (arr[i][j] == arr[j][i]){
                    if (gift[i] > gift[j]) answer[i]++;
                    if (gift[i] < gift[j]) answer[j] ++;
                }
                
            }
        }
    
        for (int i = 0 ; i < n ; i ++){
            maxGift = Math.max(maxGift,answer[i]);
        }
        
        return maxGift;
    }
}