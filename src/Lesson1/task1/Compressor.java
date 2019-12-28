package Lesson1.task1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public interface Compressor {
    OutputStream compress (String inputFile, String outputFile) throws IOException;
}
