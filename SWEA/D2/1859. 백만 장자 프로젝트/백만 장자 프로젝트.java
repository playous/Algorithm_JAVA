import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
            int[] price =new int[n];
            long answer = 0;
            
            for (int i = 0; i < n ; i++){
                price[i] = sc.nextInt();
            }
            for (int i = n - 1 ; i > 0 ; i--){
                int p = price[i];
                long sum = 0;
                while(price[i-1] <= p){
                    sum += (p - price[i-1]);
                    i--;
                    if(i == 0) break;
                }
                answer += sum;
            }
            
            System.out.println("#" + test_case + " " + answer);
		}
	}
}