import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int now = 0;
            boolean flag = true;
			int n = sc.nextInt();
            int p = sc.nextInt();
            
            for (int i = 1; i <= n ; i++){
                now += i;
                if(now == p) flag = false;
            }

            now = flag ? now : now - 1;
            
            System.out.println(now);
		}
	}
}