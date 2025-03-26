import java.util.*;
public class Diameter {

    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static int[] downPath;
    static int[] diameter=new int[2000000];
    
    public static void evalDown(int node, int parent){
        int bestChildDownPath = 0;
        boolean isLeaf = true;

        for(int child : adj.get(node)){
            if(child != parent){
                isLeaf = false;

                bestChildDownPath = Math.max(bestChildDownPath, downPath[child]);
            }
        }

        downPath[node] =  isLeaf ? 0 : 1 + bestChildDownPath;

    }

    public static void solve(int node, int parent){
        int maxDia = 0;
        ArrayList<Integer> childHeight = new ArrayList<>();

        for(int child : adj.get(node)){
            if(child != parent){
                solve(child, node);
                childHeight.add(downPath[child]);
                maxDia = Math.max(maxDia, diameter[child]);

            }
        }

        Collections.sort(childHeight, Collections.reverseOrder()); 

        if(childHeight.size() == 0) diameter[node] = 0;
        else if(childHeight.size() == 1) diameter[node] = 1 + childHeight.get(0);
        else diameter[node] = 2 + childHeight.get(0) + childHeight.get(1);

        diameter[node] = Math.max(diameter[node], maxDia);

    }
    
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        downPath = new int[n + 1];
        

        for(int i=1;i<n;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

       System.out.println(diameter[1]);
    }
}


