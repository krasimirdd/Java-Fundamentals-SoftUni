package ex8;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;

public class GetFolderSize {
    public static void main(String[] args) {

        final String inputFileName =
                "E:\\Projects\\IntelliJ_Projects\\JavaFundamentals\\FilesAndStreams\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        final String outputFileName
                = "E:\\Projects\\IntelliJ_Projects\\JavaFundamentals\\FilesAndStreams\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output8.txt";

        PrintWriter writer = null;
        File root = new File(inputFileName);
        ArrayDeque<File> foldersToTraverse = new ArrayDeque<>();
        int size = 0;

        try {

            writer = new PrintWriter(new FileWriter(outputFileName));

            foldersToTraverse.addAll(Arrays.asList(Objects.requireNonNull(root.listFiles())));

            while (!foldersToTraverse.isEmpty()) {
                File curr = foldersToTraverse.poll();
                if (curr.isFile()) {
                    size += curr.length();
                } else {
                    foldersToTraverse.addAll(Arrays.asList(Objects.requireNonNull(curr.listFiles())));
                }

            }

//            System.out.printf("Folder size: %s", size);
            writer.printf("Folder size: %d", size);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
