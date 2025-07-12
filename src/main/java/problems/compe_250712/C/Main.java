package problems.compe_250712.C;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//貪欲法
public class Main {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static long a, n;

    public static void main(String[] args) {
        a = in.nextLong();
        n = in.nextLong();
        solve();
    }

    // x を base 進数で見たときに回文かどうか
    static boolean isPalindromic(long x, long base) {
        List<Long> digits = new ArrayList<>();
        while (x > 0) {
            digits.add(x % base);
            x /= base;
        }
        int size = digits.size();
        for (int i = 0; i < size / 2; i++) {
            if (!digits.get(i).equals(digits.get(size - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    static void solve() {
        long b = 10;
        List<Long> results = new ArrayList<>();
        //10のべき乗をキャッシュ
        List<Long> powb = new ArrayList<>();
        powb.add(1L);
        int len = 1;

        while (true) {
            // 10^len を準備
            while (powb.size() < len) {
                long last = powb.get(powb.size() - 1);
                powb.add(last * b);
            }

            if (powb.get(len - 1) > n) break;

            int halfLen = (len + 1) / 2;
            int[] d = new int[halfLen];
            d[0] = 1; // 最上位桁は1から開始（leading zero防止）

            while (true) {
                // d に対応する回文数を生成
                long val = 0;
                for (int i = 0; i < len; i++) {
                    int idx = (i < halfLen) ? i : (len - 1 - i);
                    val += powb.get(i) * d[idx];
                }

                if (val <= n && isPalindromic(val, a)) {
                    results.add(val);
                }

                // 次のdを生成（10進数でカウントアップのように）
                boolean carry = true;
                for (int i = halfLen - 1; i >= 0 && carry; i--) {
                    if (d[i] < 9) {
                        d[i]++;
                        carry = false;
                    } else {
                        d[i] = 0;
                    }
                }
                if (carry) break; // 全て桁あふれしたら終了
            }

            len++;
        }

        long total = 0;
        for (long val : results) {
            total += val;
        }
        out.print(total);
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
