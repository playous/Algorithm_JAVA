class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        StringBuilder sb = new StringBuilder();
     
        int len = stringToTime(video_len);
        int cur = stringToTime(pos);
        int op_s = stringToTime(op_start);
        int op_e = stringToTime(op_end);
        
        if (cur >= op_s && cur < op_e) cur = op_e;
        
        for (String s : commands){
            if (s.equals("next")){
                cur += 10;
                if (cur > len) cur = len;
            }
            if (s.equals("prev")){
                 cur -= 10;
                if (cur < 0) cur = 0;
            }
            if (cur >= op_s && cur < op_e) cur = op_e;
        }
        sb.append(String.format("%02d:%02d", cur / 60, cur % 60));
        
        return sb.toString();
    }
    
    int stringToTime(String s){
        String[] arr = s.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}