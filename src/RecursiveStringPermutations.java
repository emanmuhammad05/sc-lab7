import java.util.HashSet;
import java.util.Set;

public class RecursiveStringPermutations {
    public static void main(String[] args) {
        String input = "abc"; // Replace with user input if needed
        Set<String> permutations = generatePermutations(input);
        
        System.out.println("Permutations: " + permutations);
    }

    public static Set<String> generatePermutations(String str) {
        Set<String> permutations = new HashSet<>();
        if (str == null || str.isEmpty()) {
            return permutations;
        }
        permute(str, "", permutations);
        return permutations;
    }

    private static void permute(String str, String prefix, Set<String> permutations) {
        if (str.isEmpty()) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permute(rem, prefix + str.charAt(i), permutations);
            }
        }
    }
}
