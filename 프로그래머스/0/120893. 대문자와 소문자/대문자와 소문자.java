class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        
        for (char ch : my_string.toCharArray()){
            if (ch >= 'a' && ch <= 'z')
                sb.append((char)(ch - 'a' + 'A'));
            else sb.append((char)(ch - 'A' + 'a'));
        }
        return sb.toString();
    }
}