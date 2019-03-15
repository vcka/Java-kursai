package controller.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReaderService {
    public static List<String> readFile(String fileDir) {
        Scanner scanner = null;
        List<String> readLines = new ArrayList<>();
        try {
            scanner = new Scanner(new File(fileDir));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanner.next();
        while (scanner.hasNext()) {
            readLines.add(scanner.next());
        }
        return readLines;
    }
}
