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
        String zipFile = "c:\\Users\\user\\IdeaProjects\\HillelHomeWorks\\src\\Lesson1\\task1\\zip_compressed.zip";
        String gzipFile = "c:\\Users\\user\\IdeaProjects\\HillelHomeWorks\\src\\Lesson1\\task1\\gzip_compressed.gzip";

        Compressor compressor = new ZipCompressor();
        compressor.compress(sourceFile,zipFile);

        Compressor compressor1 = new GzipCompressor();
        compressor.compress(sourceFile,gzipFile);

    }
}