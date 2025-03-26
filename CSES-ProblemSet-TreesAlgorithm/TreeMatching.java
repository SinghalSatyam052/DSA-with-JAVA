import java.util.ArrayList;
import java.util.Scanner;

public class TreeMatching {
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static int[][] dp = new int[200001][2];

    public static void solve(int src, int par){
        dp[src][0] = dp[src][1] = 0;

        boolean isLeaf = true;

        for(int child : adj.get(src)){
            if(par != child){
                isLeaf = false;
                solve(child, src);
            }
        }

        if(isLeaf) return;

        for(int child : adj.get(src)){
            if(par != child){
                dp[src][0]+=Math.max(dp[child][0],dp[child][1]);
            }
        }

        for(int child : adj.get(src)){
            if(child != par){
                dp[src][1] = Math.max(dp[src][1], 1 + dp[child][0] + dp[src][0] - Math.max(dp[child][0],dp[child][1]));
            }
        }
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        

        for(int i=1;i<n;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        
       solve(1,0);
       System.out.println(Math.max(dp[1][0],dp[1][1]));
    }
}
