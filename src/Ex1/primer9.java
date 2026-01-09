package Ex1;

import java.io.*;

public class primer9 {
    static void main(String[] args) throws IOException {
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("D:\\MyFile1.txt"), "cp1251"));

            bw = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream("D:\\MyFile2.txt"), "cp1251"));

            int lineCount = 0;
            String s;

            while ((s = br.readLine()) != null) {
                lineCount++;
                System.out.println(lineCount + ": " + s);
                bw.write(lineCount + ": " + s);
                bw.newLine();
            }
            System.out.println("Переписано " + lineCount + " строк");
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            if (br != null) br.close();
            if (bw != null) {
                bw.flush();
                bw.close();
            }
        }
    }
}
