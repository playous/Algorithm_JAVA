class Solution {
    public String solution(String polynomial) {
        StringBuilder sb = new StringBuilder();
        
        String[] st = polynomial.split(" \\+ ");
        int x1 = 0;
        int x0 = 0;
        
        for (String s : st){
            int len = s.length();
            if(s.contains("x")){
                if(s.length() == 1) x1 += 1;
                else x1 += Integer.parseInt(s.substring(0,len-1));
            }
            else {
                x0 += Integer.parseInt(s.substring(0,len));
            }
        }
        
        if(x1 != 0) {
            if (x1 == 1) sb.append("x");
            else sb.append(String.valueOf(x1) +"x");
        }
        if (x1 != 0 && x0 != 0) sb.append(" + ");
        if(x0 != 0){
            sb.append(String.valueOf(x0));
        }
    
        return sb.toString();
    }
}