import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RecursiveFileSearch {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java RecursiveFileSearch <directory> <filename>");
            return;
        }

        String directoryPath = args[0];
        String fileName = args[1];

        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("The provided directory does not exist or is not a directory.");
            return;
        }

        List<String> foundPaths = new ArrayList<>();
        searchFile(directory, fileName, foundPaths);

        if (foundPaths.isEmpty()) {
            System.out.println("File not found.");
        } else {
            System.out.println("File(s) found at:");
            foundPaths.forEach(System.out::println);
        }
    }

    public static void searchFile(File directory, String fileName, List<String> foundPaths) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    searchFile(file, fileName, foundPaths);
                } else if (file.getName().equals(fileName)) {
                    foundPaths.add(file.getAbsolutePath());
                }
            }
        }
    }
}
