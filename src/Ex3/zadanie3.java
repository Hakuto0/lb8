package Ex3;

import java.io.*;
import java.util.*;

public class zadanie3 {

    private static final char[] CONSONANTS = {
            'б','в','г','д','ж','з','й','к','л','м','н','п','р','с','т','ф','х','ц','ч','ш','щ',
            'Б','В','Г','Д','Ж','З','Й','К','Л','М','Н','П','Р','С','Т','Ф','Х','Ц','Ч','Ш','Щ'
    };

    static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        createTestFile(inputFile);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"))) {

            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;
                String[] words = line.split("\\s+");
                List<String> consonantWords = new ArrayList<>();

                for (String word : words) {
                    if (!word.isEmpty() && startsWithConsonant(word)) {
                        consonantWords.add(word);
                    }
                }

                if (!consonantWords.isEmpty()) {
                    bw.write("Строка " + lineNumber + ": ");
                    bw.write(String.join(" ", consonantWords));
                    bw.write(" | Количество: " + consonantWords.size());
                    bw.newLine();
                }
            }

            System.out.println("Результат записан в " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean startsWithConsonant(String word) {
        char first = word.charAt(0);
        for (char c : CONSONANTS) {
            if (first == c) return true;
        }
        return false;
    }
    
    private static void createTestFile(String inputFile) {
        String[] text = {
                "Мороз и солнце; день чудесный!",
                "Еще ты дремлешь, друг прелестный —",
                "Пора, красавица, проснись:",
                "Открой сомкнуты негой взоры"
        };

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(inputFile), "UTF-8"))) {
            for (String s : text) {
                bw.write(s);
                bw.newLine();
            }
            System.out.println("Входной файл " + inputFile + " создан");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

