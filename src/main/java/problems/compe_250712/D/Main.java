package problems.compe_250712.D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

//正答できなかった問題
public class Main {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

        public static void main(String[] args) {
        int n = in.nextInt();
        int m = in.nextInt();
        long[] homes = new long[n];
        for (int i = 0; i < n; i++) {
            homes[i] = in.nextLong();
        }

        Arrays.sort(homes);

        if (m >= n) {
            out.println(0);
            out.flush();
            return;
        }
        // 各区分の距離を算出
        long[] diffs = new long[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diffs[i] = homes[i + 1] - homes[i];
        }

        Arrays.sort(diffs);

        //距離を近い順に3つに分けたい=距離が大きいところ(M-1)個分カット(3つにわけたいので2つに区切る)
        //差分が N - 1 個ある中で、
        //(N - 1) - (M - 1) = N - M 個の差分を使って、区間を連結する。
        long total = 0;
        for (int i = 0; i < n - m; i++) {
            total += diffs[i];
        }

        out.println(total);
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
