import java.util.*;
public class Subordinates {
    static Map<Integer,ArrayList<Integer>> tree = new HashMap<>();

    public static void solve(int src, int par, int[] ans){
        int subord = 0;
        for(int child : tree.getOrDefault(src, new ArrayList<>())){
            if(child != par){
                solve(child, src, ans);
                subord += 1 + ans[child];
            }
        }
        ans[src] = subord;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i =1;i<=n;i++) tree.put(i,new ArrayList<>());

        for(int i =2;i<=n;i++){
            int x = sc.nextInt();
            tree.get(x).add(i);
            tree.get(i).add(x);
        }

        int[] ans = new int[n+1];

        solve(1,0,ans);

        for(int i=1;i<=n;i++) System.out.print(ans[i] +" ");

    }
}
