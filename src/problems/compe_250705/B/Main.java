package problems.compe_250705.B;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        
        int n = in.nextInt();
        String[] slist = new String[n];

        for(int i=0;i<n;i++){
            slist[i] = in.next();
        }
        Set<String> ans = new HashSet<String>();
        
        for(int i=0;i<n-1;i++){
            
            for(int j=i+1;j<n;j++){
                StringBuilder br1= new StringBuilder();
                StringBuilder br2= new StringBuilder();
                br1.append(slist[i]).append(slist[j]);
                br2.append(slist[j]).append(slist[i]);
                ans.add(br1.toString());
                ans.add(br2.toString());
            }
        }
        out.print(ans.size());

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
