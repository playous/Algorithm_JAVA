import java.util.*;

class Solution {
    static class Node {
        String name;
        int time;
        public Node (String name, int time){
            this.name = name;
            this.time = time;
        }
    }
    
    public int[] solution(int[] fees, String[] records) {
        int n = records.length;
        Set<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> answerMap = new HashMap<>();
        List<Node> list = new ArrayList<>();
        
        for (int i = 0 ; i < n ; i ++){
            String[] info = records[i].split(" ");
            int time = calc(info[0]);
            String name = info[1];
            if (info[2].equals("IN")){
                set.add(name);
                map.put(name, time);
            }
            else {
                set.remove(name);
                int inTime = map.get(name);
                int parkTime = time - inTime;
                answerMap.put(name, answerMap.getOrDefault(name, 0) + parkTime);
            }
        }
        
        for (String name : set){
            int outTime = calc("23:59");
            int parkTime = outTime - map.get(name);
            answerMap.put(name, answerMap.getOrDefault(name, 0) + parkTime);
        }
        
        for (String name : map.keySet()){
            int time = answerMap.get(name);
            int answerTime = fees[1];
            if(time > fees[0]) {
                int remain = time - fees[0];
                int cnt = remain / fees[2];
                if (remain % fees[2] == 0) answerTime += (cnt * fees[3]);
                else answerTime += (cnt * fees[3]) + fees[3];
            }
            list.add(new Node(name, answerTime));
        }
        
        list.sort((a,b) -> a.name.compareTo(b.name));
        
        int len = list.size();
        int[] answer = new int[len];
        
        for (int i = 0 ; i < len ; i ++){
            answer[i] = list.get(i).time;
        }
        
        return answer;
    }
    
    public int calc(String s){
        String[] t = s.split(":");
        int h = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
        return (h * 60) + m ;
    }
}