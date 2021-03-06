/*Найти максимальную длину строки в текстовом файле, разделителем считаем '\n'.
Предложить два наиболее оптимальных решения и добавить сравнительный benchmark.
При загрузке данных помнить что файлы бывают большими..*/

package Lesson1.task2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> dataFromFile = null;
        long start0 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            try {
                dataFromFile = Files.readAllLines(Paths.get("c:\\Users\\user\\IdeaProjects\\HillelHomeWorks\\src\\Lesson1\\task2\\file.txt"));
            } catch (IOException e) {
                e.printStackTrace();
            }
//        System.out.println("содержимое файла:");
            //      dataFromFile.forEach(System.out::println);
            //    dataFromFile.forEach(System.out::println);

            OptionalInt max = dataFromFile.stream().mapToInt(String::length).max();
        }
        //System.out.println("\nМаксимальная длинна строки: " + max.getAsInt() + " символов");
        System.out.println(System.currentTimeMillis() - start0);
        int maxLengthStr = 0;
        long start = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            BufferedReader reader = new BufferedReader(new FileReader("c:\\Users\\user\\IdeaProjects\\HillelHomeWorks\\src\\Lesson1\\task2\\file.txt"));
            // считаем сначала первую строку

            String line = reader.readLine();
            while (line != null) {
                if (line.length() > maxLengthStr) {
                    maxLengthStr = line.length();
                }
                line = reader.readLine();
            }
        }
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("\nМаксимальная длинна строки: " + maxLengthStr + " символов");
    }
}

