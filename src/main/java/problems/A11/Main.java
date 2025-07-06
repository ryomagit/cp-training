package problems.A11;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        
        int n = in.nextInt();
        int x = in.nextInt();

        int[] a = new int[n+1];
        for(int i=1;i<=n;i++){
            a[i] = in.nextInt();
        }

        int targetIndex = binarySearchIndex(x,a);
        out.print(targetIndex);

        out.flush();  
    }

    //2分探索(指定した値がリストの何番目か)
    private static int binarySearchIndex(int targetVal,int[] list){
        int leftIndex = 1;
        int rightIndex = list.length - 1;
        while(leftIndex <= rightIndex){
            //中央値(小数点切り捨て)
            int centerIndex = (leftIndex + rightIndex)/2;
            int val = list[centerIndex];
            if(val == targetVal){
                return centerIndex;
            } else if(val < targetVal){
                leftIndex = centerIndex+1;
            } else {
                rightIndex = centerIndex - 1;
            }
        }
        return -1;
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
