package problems.compe_250705.C;
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

    static class Pair{
        int value,number;
        Pair(int value,int number){
            this.value = value;
            this.number = number;
        }
    }

    public static void main(String[] args) {
        
        int q = in.nextInt();
        Deque<Pair> ans = new ArrayDeque<>();

        for(int i=0;i<q;i++){
            String query = in.nextLine();
            String[] tokens = query.split("\\s+");
            if(tokens.length == 3){
                int c = Integer.parseInt(tokens[1]);
                int x = Integer.parseInt(tokens[2]);
                ans.addLast(new Pair(x,c));
            }
            if(tokens.length==2){
                int k = Integer.parseInt(tokens[1]);
                long del = 0;
                while(k > 0){
                    Pair first = ans.peekFirst();
                    if(first.number <= k){
                        k-= first.number;
                        del += (long) first.number*first.value;
                        ans.pollFirst();
                    }else{
                        first.number -=k;
                        del += (long) first.value*k;
                        k=0;
                    }
                }
                out.println(del);
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
