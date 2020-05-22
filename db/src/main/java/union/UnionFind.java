package union;

public class UnionFind {
   private int count;
   private int[] parent;
   private int[] size;
   public UnionFind(int n){
       this.count = n;
       parent = new int[n];
       size = new int[n];
       for (int i = 0; i < n; i++) {
           parent[i] = i;
           size[i] = 1;
       }
   }
   private int find(int x){
       while (parent[x] != x){
           // Â·¾¶Ñ¹Ëõ£»
           parent[x] = parent[parent[x]];
           x = parent[x];
       }
       return x;
   }
   public void union(int p, int q){
       int rootP = find(p);
       int rootQ = find(q);
       if(rootP == rootQ) return;
       if(size[rootP] > size[rootQ]){
           parent[rootQ] = rootP;
           size[rootP] += size[rootQ];
       }else{
           parent[rootP] = rootQ;
           size[rootQ] += size[rootP];
       }
   }
   public boolean connected(int p,int q){
       int rootP = find(p);
       int rootQ = find(q);
       return rootP == rootQ;
   }
   public int count() {
       return count;
   }
    public int findCircleNum(int[][] M) {
       int n = M.length;
       UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(M[i][j] == 1){
                    uf.union(i, j);
                }
            }
        }
        return uf.count();
    }
}
