package problems.A10;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        
        int n = in.nextInt();
        int[] A = new int[n+1];
        for(int i=1;i<=n;i++){
            A[i] = in.nextInt();
        }
        int[] P = new int[n+1];
        P[1] = A[1];
        for(int i=2;i<=n;i++){
            P[i] = Math.max(A[i],P[i-1]);
        }
        int[] Q = new int[n+1];
        Q[n] = A[n];
        for(int i=n-1;i>=1;i--){
            Q[i] = Math.max(Q[i+1],A[i]);
        }
        int d = in.nextInt();
        for(int i=1;i<=d;i++){
            int l= in.nextInt();
            int r=in.nextInt();
            int ans = Math.max(P[l-1],Q[r+1]);
            out.println(ans);
        }
        out.flush();  
    }

    // 高速入力クラス
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            try { return br.readLine(); }
            catch (IOException e) { e.printStackTrace(); return null; }
        }
    }
}
