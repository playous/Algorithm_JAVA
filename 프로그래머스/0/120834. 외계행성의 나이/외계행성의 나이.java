class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        char[] ch = String.valueOf(age).toCharArray();
        
        for (char c : ch){
            sb.append((char)('a' + (c - '0')));
        }
        return sb.toString();
    }
}