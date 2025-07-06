package problems.compe_250628.C;
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
        
        int t = in.nextInt();

        for(int i=0;i<t;i++){
            int n = in.nextInt();
            int[] sList = new int[n];
            for(int j=0;j<n;j++){
                sList[j] = in.nextInt();
            }
            int count = 1;
            int last = 0;
            boolean[] used = new boolean[n];
            while(true){
                if(sList[last]*2 >= sList[n-1]){
                    count += 1;
                    out.println(count);
                    break;
                }
                int next = -1;
                for(int x=1;x<n-1;x++){
                    if(used[x]) continue;
                    if(sList[last]*2 >= sList[x]){
                        if(next != -1 && sList[next] >= sList[x]) continue;
                        next = x;
                    }
                }
                if(next == -1 || sList[last] >= sList[next]){
                    out.println(-1);
                    break;
                }
                used[next] = true;
                last = next;
                count += 1;
            }
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
