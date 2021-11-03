import io.vavr.collection.List;
import io.vavr.control.Option;

import java.util.Objects;

import static io.vavr.API.*;
import static io.vavr.Patterns.$Cons;
import static io.vavr.Patterns.$Nil;

/**
 * Find the second last element of a list.
 */
public class P02 {

    public static <T> Option<T> secondLast(List<T> elements) {
        return Match(elements).of(
                Case($(Objects::isNull), a -> None()),
                Case($Nil(), a -> None()),
                Case($Cons($(), $Cons($(), $Nil())), (a, tail) -> Some(a)),
                Case($Cons($(), $()), (a, tail) -> secondLast(tail))
        );
    }
}