import io.vavr.collection.List;

import java.util.Objects;

import static io.vavr.API.*;
import static io.vavr.Patterns.$Cons;
import static io.vavr.Patterns.$Nil;

/**
 * Find the number of elements of a list
 */
public class P04 {

    private static <T> int length(List<T> elements, int accumulator) {
        return Match(elements).of(
                Case($(Objects::isNull), a -> 0),
                Case($Nil(), a -> 0),
                Case($Cons($(), $Nil()), (a, tail) -> accumulator),
                Case($Cons($(), $()), (a, tail) -> length(tail, accumulator + 1))
        );
    }

    public static <T> int length(List<T> elements) {
        return length(elements, 1);
    }
}