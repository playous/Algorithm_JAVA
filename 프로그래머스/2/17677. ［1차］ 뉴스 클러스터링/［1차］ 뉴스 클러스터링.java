import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        
        int len1 = str1.length();
        int len2 = str2.length();
        
        for (int i = 0; i <= len1 - 2; i ++){
            String str = str1.substring(i, i + 2);
            
            if (!check(str)) continue;
            
            set1.add(str);
            map1.put(str, map1.getOrDefault(str, 0) + 1);
        }
        
        for (int i = 0; i <= len2 - 2; i ++){
            String str = str2.substring(i, i + 2);
            
            if (!check(str)) continue;
            
            set2.add(str);
            map2.put(str, map2.getOrDefault(str, 0) + 1);
        }
        
        HashSet<String> set3 = new HashSet<>();
        
        for (String s : set1){
            set3.add(s);
        }
        
        for (String s : set2){
            set3.add(s);
        }
        
        int mom = 0;
        int son = 0;
        
        for (String s : set3){
            if (set1.contains(s) && set2.contains(s)){
                mom += Math.max(map1.get(s), map2.get(s));
            }
            else if (set1.contains(s)){
                mom += map1.get(s);
            }
            else mom += map2.get(s);
        }
        
        for (String s : set3){
            if (set1.contains(s) && set2.contains(s)){
                son += Math.min(map1.get(s), map2.get(s));
            }
        }
        
        if (mom == 0) {
           return 65536; 
        }
        
        int answer = (int)((double)son / mom * 65536);
        return answer;
    }
    
    public boolean check(String str){
        char ch1 = str.charAt(0);
        char ch2 = str.charAt(1);
        
        if (ch1 < 'a' || ch1 > 'z') return false;
        if (ch2 < 'a' || ch2 > 'z') return false;
        
        return true;
    }
}