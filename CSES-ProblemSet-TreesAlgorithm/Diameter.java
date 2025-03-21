import java.util.*;
public class Diameter {

    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static int maxDia = 0;
 
    public static int height(int node, int parent){
        int h1 = 0,h2 = 0;

        for(int child : adj.get(node)){
            
            int childHt = 0;
            if(child != parent) childHt = height(child, node);

            if(childHt>h1) {
                h2 = h1;
                h1 = childHt;
            }else if(childHt>h2) h2 = childHt;
        }
        
        maxDia = Math.max(maxDia, h2 + h1 + 2);

        return h1 + 1;
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

       System.out.println(height(1,-1));
    }
}


