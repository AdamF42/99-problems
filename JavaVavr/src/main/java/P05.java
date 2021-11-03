import io.vavr.collection.List;
import io.vavr.control.Option;

import java.util.Objects;

import static io.vavr.API.*;
import static io.vavr.Patterns.$Cons;
import static io.vavr.Patterns.$Nil;

/**
 * Reverse a list
 */
public class P05 {

    private static  <T> List<T> reverse(List<T> elements, List<T> accumulator) {
        return Match(elements).of(
                Case($(Objects::isNull), a -> List.of()),
                Case($Nil(), a -> accumulator),
                Case($Cons($(), $()), (a, tail) -> reverse(tail, accumulator.push(a)))
        );
    }

    public static <T> List<T> reverse(List<T> elements) {
        return reverse(elements, List.of());
    }
}