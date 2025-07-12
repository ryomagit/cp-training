package problems.A14;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        
        int n = in.nextInt();
        int k = in.nextInt();
        int[] aBox = new int[n+1];
        int[] bBox = new int[n+1];
        int[] cBox = new int[n+1];
        int[] dBox = new int[n+1];
        for(int i=0;i<n;i++){
            aBox[i] = in.nextInt();
        }
        for(int i=0;i<n;i++){
            bBox[i] = in.nextInt();
        }
        for(int i=0;i<n;i++){
            cBox[i] = in.nextInt();
        }
        for(int i=0;i<n;i++){
            dBox[i] = in.nextInt();
        }
        int[] pBox = new int[n*n];
        int[] qBox = new int[n*n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                pBox[i*n+j] = aBox[i]+bBox[j];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                qBox[i*n+j] = cBox[i]+dBox[j];
            }
        }

        Arrays.sort(qBox);
        for(int i=0;i<n*n;i++){
            int p = pBox[i];
            int goal = k - p;
            int index = binarySearchIndex(goal, qBox);
            if(index != -1 && qBox[index] == k-p){
                out.print("Yes");
                out.flush();
                return;
            }

        }
        out.print("No");
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
