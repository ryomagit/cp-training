package problems.compe_250712.A;
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
        int l = in.nextInt();
        int r = in.nextInt();
        int ans = 0;

        for(int i=0;i<n;i++){
            int start = in.nextInt();
            int end = in.nextInt();
            if(start<=l && end>=r){
                ans ++;
            }
        }
        out.print(ans);
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
