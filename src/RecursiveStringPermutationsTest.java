import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class RecursiveStringPermutationsTest {

    @Test
    public void testPermutationsOfABC() {
        Set<String> result = RecursiveStringPermutations.generatePermutations("abc");
        assertEquals(6, result.size()); // "abc" has 3! = 6 unique permutations
        assertTrue(result.contains("abc"));
        assertTrue(result.contains("acb"));
        assertTrue(result.contains("bac"));
        assertTrue(result.contains("bca"));
        assertTrue(result.contains("cab"));
        assertTrue(result.contains("cba"));
    }

    @Test
    public void testPermutationsWithDuplicates() {
        Set<String> result = RecursiveStringPermutations.generatePermutations("aab");
        assertEquals(3, result.size()); // Unique permutations: "aab", "aba", "baa"
        assertTrue(result.contains("aab"));
        assertTrue(result.contains("aba"));
        assertTrue(result.contains("baa"));
    }

    @Test
    public void testEmptyString() {
        Set<String> result = RecursiveStringPermutations.generatePermutations("");
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSingleCharacterString() {
        Set<String> result = RecursiveStringPermutations.generatePermutations("a");
        assertEquals(1, result.size());
        assertTrue(result.contains("a"));
    }
}
