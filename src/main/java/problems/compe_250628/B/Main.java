package problems.compe_250628.B;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        
        String s = in.next();
        char[] slist = s.toCharArray();
        
        String t = in.next();
        char[] tlist = t.toCharArray();
        boolean judge=true;
        for(int i=1;i<slist.length;i++){
            char tag = slist[i];
            if(Character.isUpperCase(tag)){
                char prev = slist[i-1];
                boolean chJudge = false;
                for(char tchar:tlist){
                    if(tchar == prev){
                        chJudge = true;
                    } 
                }
                if(chJudge) judge=true;
                else {judge= false;
                break;}
            }
        }
        if(judge) out.println("Yes");
        else out.println("No");
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
