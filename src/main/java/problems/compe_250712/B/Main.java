package problems.compe_250712.B;
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
        StringBuilder br = new StringBuilder();
        long length = 0;
        boolean tooLong = false;

        for(int i=0;i<n;i++){
            String text = in.next();
            long roop = in.nextLong();
            
            length += roop;
            if(length > 100){
                tooLong=true;
                break;
            }
            for(int j=0;j<roop;j++){
                br.append(text);
            }
        }
        if(tooLong) out.print("Too Long");
        else out.print(br.toString());

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
