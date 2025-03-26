import java.io.*;
import java.util.*;

public class TreeMatching {
    static ArrayList<Integer>[] adj;
    static int[][] dp;

    public static void solve(int src, int par) {
        dp[src][0] = dp[src][1] = 0;
        boolean isLeaf = true;

        for (int child : adj[src]) {
            if (child != par) {
                isLeaf = false;
                solve(child, src);
            }
        }

        if (isLeaf) return;

        int exclude = 0, include = 0;
        
        for (int child : adj[src]) {
            if (child != par) {
                exclude += Math.max(dp[child][0], dp[child][1]);
            }
        }

        for (int child : adj[src]) {
            if (child != par) {
                include = Math.max(include, 1 + dp[child][0] + exclude - Math.max(dp[child][0], dp[child][1]));
            }
        }

        dp[src][0] = exclude;
        dp[src][1] = include;
    }

    public static void main(String[] args) throws IOException {
        // Fast Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        adj = new ArrayList[n + 1];
        dp = new int[n + 1][2];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            adj[a].add(b);
            adj[b].add(a);
        }

        solve(1, 0);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }
}
