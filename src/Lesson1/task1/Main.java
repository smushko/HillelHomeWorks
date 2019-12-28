/*Реализовать паттерн Strategy для компрессии входящего OutputStream.
На выходе должен быть сжатый OutputStream в зависимости от выбранного алгоритма zip/gzip.
Использовать лямбда-конструкции,как определяется источник данных,выбор алгоритма(интерактив
 с консоли,запуск с параметрами,конфиг,..)на свое усмотрение*/

package Lesson1.task1;


import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) throws IOException {


        String sourceFile = "c:\\Users\\user\\IdeaProjects\\HillelHomeWorks\\src\\Lesson1\\task1\\test1.txt";
        FileOutputStream fos = new FileOutputStream("c:\\Users\\user\\IdeaProjects\\HillelHomeWorks\\src\\Lesson1\\task1\\compressed.zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        File fileToZip = new File(sourceFile);
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
        zipOut.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        zipOut.close();
        fis.close();
        fos.close();
    }
}