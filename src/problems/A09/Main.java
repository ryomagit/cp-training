package problems.A09;
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
        int n = in.nextInt();
        int[][] square = new int[h+2][w+2];
        for(int i = 1;i<=n;i++){
            int a= in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();
            square[a][b] += 1;
            square[a][d+1] -= 1;
            square[c+1][b] -=1;
            square[c+1][d+1] +=1;
        }
        int[][] sumSqu = new int[h+2][w+2];
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
        for(int i=1;i<=h;i++){
            for(int j=1;j<=w;j++){
                if(j>=2) out.print(" ");
                out.print(sumSqu[i][j]);
            }
            out.println();
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
