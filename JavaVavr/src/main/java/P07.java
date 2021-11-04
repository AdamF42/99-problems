import io.vavr.collection.List;

import java.util.Objects;

import static io.vavr.API.*;
import static io.vavr.Patterns.$Cons;
import static io.vavr.Patterns.$Nil;
import static io.vavr.Predicates.instanceOf;

/**
 * Transform a list, possibly holding lists as elements into a 'flat' list by replacing each list with its elements (recursively).
 */
public class P07 {

    public static <T> List<T> flatten(List<T> elements) {
        return flatten(elements, List.of());
    }

    public static <T> List<T> flatten(List<T> elements, List<T> acc) {
        return Match(elements).of(
                Case($(Objects::isNull), a -> null),
                Case($Nil(), a -> acc),
                Case($Cons($(instanceOf(List.class)), $()), (a, tail) -> flatten(tail, acc.appendAll(a))),
                Case($Cons($(), $()), (a, tail) -> flatten(tail, acc.append(a)))
        );
    }

}