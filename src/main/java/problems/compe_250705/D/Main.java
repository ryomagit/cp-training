package problems.compe_250705.D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

//貪欲法
public class Main {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int T = in.nextInt();

        for (int t = 0; t < T; t++) {
            int N = in.nextInt();
            Long[] A = new Long[N];

            for (int i = 0; i < N; i++) {
                A[i] = in.nextLong();
            }

            if (isGeometric(A)) {
                out.println("Yes");
            } else {
                out.println("No");
            }
        }

        out.flush();
    }

    static boolean isGeometric(Long[] A) {
        int N = A.length;

        // すべて同じ値なら、Yes
        boolean allSame = true;
        for (int i = 1; i < N; i++) {
            if (A[i] != A[0]) {
                allSame = false;
                break;
            }
        }
        if (allSame) return true;

        // 公比-1かどうか
        long x = A[0];
        int cntPos = 0, cntNeg = 0;
        for (long val : A) {
            if (val == x) cntPos++;
            else if (val == -x) cntNeg++;
            else {
                cntPos = -1;
                break;
            }
        }
        if (cntPos + cntNeg == N && Math.min(cntPos, cntNeg) == N / 2) return true;

        // 公比の絶対値が 1 でないなら、絶対値でソートしたときに等比数列である必要がある
        Arrays.sort(A, (a, b) -> Long.compare(Math.abs(b), Math.abs(a)));

        for (int i = 0; i + 2 < N; i++) {
            long left = A[i] * A[i + 2];
            long mid = A[i + 1] * A[i + 1];
            if (left != mid) return false;
        }

        return true;
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
