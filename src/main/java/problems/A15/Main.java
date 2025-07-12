package problems.A15;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
        }
        int[] aSort = Arrays.copyOf(a, n);
        Arrays.sort(aSort);

        List<Integer> x = new ArrayList<>();
        x.add(aSort[0]);
        //重複削除
        for(int i=1;i<n;i++){
            if(aSort[i] != aSort[i-1]){
                x.add(aSort[i]);
            }
        }
        int count = 0;
        for(int aVal:a){
            int leftIndex=0;
            int rightIndex=x.size()-1;
            int bVal=0;
            while(leftIndex<=rightIndex){
                int centerIndex = (rightIndex + leftIndex)/2;
                int value = x.get(centerIndex);
                if(value == aVal){
                    bVal = centerIndex+1;
                    break;
                } else if(value>aVal){
                    rightIndex = centerIndex-1;
                } else {
                    leftIndex=centerIndex+1;
                }
            }
            b[count]=bVal;
            count ++;
        }
        boolean first = true;
        for(int value:b){
            if(!first){
                out.print(" ");
            }
            out.print(value);
            first = false;
        }
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
