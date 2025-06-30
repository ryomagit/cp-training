package problems.A08;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        
        int h = in.nextInt();
        int w = in.nextInt();
        int[][] square = new int[h+1][w+1];
        for(int i = 1;i<=h;i++){
            for(int j=1;j<=w;j++){
                square[i][j] = in.nextInt();
            }
        }
        int[][] sumSqu = new int[h+1][w+1];
        for(int i=1;i<=h;i++){
            for(int j=1;j<=w;j++){
                sumSqu[i][j] = sumSqu[i][j-1] + square[i][j];
            }
        }
        for(int i=1;i<=w;i++){
            for(int j=1;j<=h;j++){
                sumSqu[j][i] = sumSqu[j-1][i] + sumSqu[j][i];
            }
        }
        int q = in.nextInt();
        for(int i=1;i<=q;i++){
            int hs = in.nextInt();
            int ws = in.nextInt();
            int he = in.nextInt();
            int we = in.nextInt();
            int sum = sumSqu[he][we]-sumSqu[hs-1][we]-sumSqu[he][ws-1] + sumSqu[hs-1][ws-1];
            out.println(sum);
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
