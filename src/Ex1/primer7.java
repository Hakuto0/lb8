package Ex1;

import java.io.*;

public class primer7 {
    static void main(String[] args) throws IOException {
        BufferedReader br = null;
        BufferedWriter out = null;
        try {
            br = new BufferedReader(new FileReader("D:\\MyFile1.txt"), 1024);
            out = new BufferedWriter(new FileWriter("D:\\MyFileCopy.txt"));

            int LineCount = 0;
            String s;

            while ((s = br.readLine())!=null) {
                LineCount++;
                System.out.println(LineCount + ":"+s);
                out.write(s);
                out.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        finally {
            br.close();
            out.flush();
            out.close();
        }
    }
}
