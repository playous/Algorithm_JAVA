import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<Character,Integer> map = new HashMap<>();
        
        map.put('R',0);
        map.put('T',0);
        map.put('C',0);
        map.put('F',0);
        map.put('J',0);
        map.put('M',0);
        map.put('A',0);
        map.put('N',0);
        
        char[] arr = {'R','C','J','A'};
        
        int len = survey.length;
        
        for (int i = 0 ; i < len ; i++){
            char s = survey[i].charAt(0);
            int c = 4 - choices[i];
            map.put(s ,map.get(s) + c);
        }
        if (map.get('T') > map.get('R')) arr[0] = 'T';
        if (map.get('F') > map.get('C')) arr[1] = 'F';
        if (map.get('M') > map.get('J')) arr[2] = 'M';
        if (map.get('N') > map.get('A')) arr[3] = 'N';
        
        return String.valueOf(arr);
    }
}