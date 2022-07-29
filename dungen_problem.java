import java.util.Scanner;

public class dungen_problem {


            static int minInitialPoints(int arr[][],int R,int C)
            {

                int dp[][] = new int[R][C];
                int m = R, n = C;

                if(arr[m-1][n-1] > 0){
                    dp[m-1][n-1] = 1;
                }
                else{
                    dp[m-1][n-1] = Math.abs(arr[m-1][n-1]) + 1;
                }




                for (int i = m-2; i >= 0; i--) {
                    dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - arr[i][n - 1], 1);
                }
                for (int j = n-2; j >= 0; j--) {
                    dp[m - 1][j] = Math.max(dp[m - 1][j + 1] - arr[m - 1][j], 1);
                }


                for (int i=m-2; i>=0; i--)
                {
                    for (int j=n-2; j>=0; j--)
                    {
                        int min_points_on_exit = Math.min(dp[i+1][j], dp[i][j+1]);
                        dp[i][j] = Math.max(min_points_on_exit - arr[i][j], 1);
                    }
                }

                return dp[0][0];
            }


            public static void main (String args[])
            {
                Scanner obj = new Scanner(System.in);
                int m = obj.nextInt();
                int n = obj.nextInt();
                int[][] arr = new int[m][n];

                int R = m,C = n;
                for(int i=0;i<m;i++){
                    for(int j=0;j<n;j++){
                        arr[i][j]= obj.nextInt();
                    }
                }
                System.out.println("Minimum Points Required: "+
                        minInitialPoints(arr,R,C) );
            }
        }



