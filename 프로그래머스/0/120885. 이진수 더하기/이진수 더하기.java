class Solution {
    public String solution(String bin1, String bin2) {
        int n1 = Integer.parseInt(bin1,2);
        int n2 = Integer.parseInt(bin2,2);
       
        return Integer.toBinaryString(n1 + n2);
    }
}