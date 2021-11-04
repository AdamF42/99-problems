import io.vavr.collection.List;

import java.util.Objects;

/**
 * Find out whether a list is a palindrome.
 */
public class P06 {

    public static <T> boolean isPalindrome(List<T> elements) {
        List<T> reversed = P05.reverse(elements);
        return Objects.equals(elements, reversed);
    }
}