import java.util.*;

class Solution {
    
    class Node{
        int code;
        int date;
        int maximum;
        int remain;
        
        Node(int code, int date, int maximum, int remain){
            this.code = code;
            this.date = date;
            this.maximum = maximum;
            this.remain = remain;
        }
    }
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {        
        int idx = 0;
        if(ext.equals("date")) idx = 1;
        if(ext.equals("maximum")) idx = 2;
        if(ext.equals("remain")) idx = 3;
        
        List<Node> list = new ArrayList<>();
        
        for (int i = 0 ; i < data.length; i++){
            if (data[i][idx] < val_ext){
                list.add(new Node(data[i][0], data[i][1], data[i][2], data[i][3]));
            }
        }
        
        if(sort_by.equals("code")){
            list.sort((a, b) -> a.code - b.code);
        }
        
        if(sort_by.equals("date")){
            list.sort((a, b) -> a.date - b.date);
        }
        
        if(sort_by.equals("maximum")){
            list.sort((a, b) -> a.maximum - b.maximum);
        }
        
        if(sort_by.equals("remain")){
            list.sort((a, b) -> a.remain - b.remain);
        }
        
        
        int[][] answer = new int[list.size()][4];
        
        for (int i = 0 ; i < list.size(); i ++){
            Node cur = list.get(i);
            
            answer[i][0] = cur.code;
            answer[i][1] = cur.date;
            answer[i][2] = cur.maximum;
            answer[i][3] = cur.remain;
        }
        
        return answer;
    }
}