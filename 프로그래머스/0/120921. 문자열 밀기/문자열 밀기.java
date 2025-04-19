class Solution {
    public int solution(String A, String B) {
        int len = A.length();
        char[] a = A.toCharArray();
        
        for (int i = 0 ; i < len; i ++){
            StringBuilder sb = new StringBuilder();
            int cnt = len;
            for (int j = len - i;cnt > 0;j++){
                sb.append(a[j%len]);
                cnt--;
            }
            System.out.println(sb.toString());
            if(sb.toString().equals(B)) return i;
        }
        
        return -1;
    }
}