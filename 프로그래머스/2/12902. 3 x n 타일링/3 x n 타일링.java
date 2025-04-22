class Solution {
    public int solution(int n) {
        // n이 홀수인 경우 불가능
        long[] arr = new long[n+1];
        arr[2] = 3;
        arr[4] = 11;
        for (int i = 6 ; i <= n ;i +=2){
            arr[i] = ((arr[i-2] * 4) - arr[i-4] + 1000000007) % 1000000007; 
        }
        return (int)arr[n];
    }
}