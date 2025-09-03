package LC;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IsomorphicTests {

    @Test
    void testIsomorphic_TrueCases() {
        isomorphic solution = new isomorphic();
        assertTrue(solution.isIsomorphic("egg", "add"));
        assertTrue(solution.isIsomorphic("paper", "title"));
        assertTrue(solution.isIsomorphic("", ""));  // empty strings
        assertTrue(solution.isIsomorphic("a", "b")); // single-char mapping
    }

    @Test
    void testIsomorphic_FalseCases() {
        isomorphic solution = new isomorphic();
        assertFalse(solution.isIsomorphic("foo", "bar"));  // mapping conflict
        assertFalse(solution.isIsomorphic("ab", "aa"));    // two map to one
        assertFalse(solution.isIsomorphic("ab", "cc"));    // both map to same
        assertFalse(solution.isIsomorphic("abc", "de"));   // different lengths
    }

    @Test
    void testIsomorphic_EdgeCases() {
        isomorphic solution = new isomorphic();
        assertTrue(solution.isIsomorphic("abab", "cdcd"));  // repeated pattern
        assertFalse(solution.isIsomorphic("abab", "cddc")); // mismatch
    }
}
