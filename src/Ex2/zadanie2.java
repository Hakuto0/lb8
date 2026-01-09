package Ex2;

import java.io.*;
import java.util.*;

public class zadanie2 {
    public static void main(String[] args) {
        String inputFile = "input.txt";   // исходный файл
        String outputFile = "output.txt"; // результирующий файл

        // 1. Создаём входной файл с тестовыми данными
        createInputFile(inputFile);

        // 2. Читаем входной файл и записываем результат
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"))) {

            // Читаем две строки
            String firstLine = br.readLine();  // первая строка (не нужна)
            String secondLine = br.readLine(); // вторая строка (нужна)
            if (secondLine != null) {
                bw.write(secondLine);
                bw.newLine();
            }

            // Читаем числа double
            List<Double> numbers = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.trim().split("\\s+");
                for (String token : tokens) {
                    try {
                        double d = Double.parseDouble(token);
                        if (d > 0) {
                            numbers.add(d);
                        }
                    } catch (NumberFormatException e) {
                        // Игнорируем нечисловые токены
                    }
                }
            }

            // Записываем положительные числа в выходной файл
            for (double num : numbers) {
                bw.write(num + " ");
            }

            System.out.println("Результат записан в " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для создания тестового входного файла
    private static void createInputFile(String inputFile) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(inputFile), "UTF-8"))) {
            bw.write("Это первая строка\n");
            bw.write("Это вторая строка\n");
            bw.write("1.5 -2.3 0 4.2 3.0\n");
            System.out.println("Входной файл " + inputFile + " создан");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


