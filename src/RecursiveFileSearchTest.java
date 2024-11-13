import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class RecursiveFileSearchTest {
    private File tempDir;

    @BeforeEach
    public void setup() throws IOException {
        tempDir = new File("tempDir");
        tempDir.mkdir();
        
        new File(tempDir, "file1.txt").createNewFile();
        File subDir = new File(tempDir, "subDir");
        subDir.mkdir();
        new File(subDir, "file2.txt").createNewFile();
    }

    @AfterEach
    public void teardown() {
        deleteDirectory(tempDir);
    }

    private void deleteDirectory(File dir) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                deleteDirectory(file);
            }
            file.delete();
        }
        dir.delete();
    }

    @Test
    public void testFileFound() {
        List<String> foundPaths = new ArrayList<>();
        RecursiveFileSearch.searchFile(tempDir, "file1.txt", foundPaths);
        assertEquals(1, foundPaths.size());
    }

    @Test
    public void testFileNotFound() {
        List<String> foundPaths = new ArrayList<>();
        RecursiveFileSearch.searchFile(tempDir, "nonExistentFile.txt", foundPaths);
        assertTrue(foundPaths.isEmpty());
    }

    @Test
    public void testFileInSubdirectory() {
        List<String> foundPaths = new ArrayList<>();
        RecursiveFileSearch.searchFile(tempDir, "file2.txt", foundPaths);
        assertEquals(1, foundPaths.size());
    }
}
