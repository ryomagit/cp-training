package problems;

import java.io.*;
import java.lang.reflect.Method;
import java.util.Scanner;

public class DebugLauncher {

    public static void main(String[] args) throws Exception {
                if (args.length < 1) {
            System.err.println("❗ 引数でproblems以下のパスを指定してください（例: A1, compe/A）");
            return;
        }

        String problemPath = args[0]; 
        String className = "problems." + problemPath.replace("/", ".") + ".Main";
        String inputPath = "src/main/java/problems/" + problemPath + "/input.txt";

        try {
            File inputFile = new File(inputPath);
            if (inputFile.exists()) {
                System.setIn(new FileInputStream(inputFile));
                System.out.println("✅ input.txt を読み込みました。: " + inputPath);
                System.out.println("📤 --- 以下、Mainクラスの出力 ---");
            } else {
                System.out.println("🔍 input.txt が見つかりません。標準入力から読み込みます。");
                System.out.println("📤 --- 以下、Mainクラスの出力 ---");
            }

            long start = System.currentTimeMillis();

            Class<?> mainClass = Class.forName(className);
            Method mainMethod = mainClass.getMethod("main", String[].class);
            mainMethod.invoke(null, (Object) new String[]{});

            long end = System.currentTimeMillis();
            System.out.println("\n✅ 実行完了: " + (end - start) + "ms");

        } catch (Exception e) {
            System.err.println("❌ 実行エラー:");
            e.printStackTrace();
        }
    }
    
}
