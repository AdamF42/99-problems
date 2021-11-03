import io.vavr.collection.List;
import io.vavr.control.Option;


import java.util.Objects;

import static io.vavr.API.*;
import static io.vavr.Patterns.$Cons;
import static io.vavr.Patterns.$Nil;

/**
 * Find the Kth element of a list.
 */
public class P03 {

    public static  <T> Option<T> kth(List<T> elements, Integer index) {
        return Match(elements).of(
                Case($(Objects::isNull), a -> None()),
                Case($Nil(), a -> None()),
                Case($Cons($(e -> index <= 0), $()), (a, tail) -> None()),
                Case($Cons($(e -> index == 1), $()), (a, tail) -> Some(a)),
                Case($Cons($(e -> index > 1), $()), (a, tail) -> kth(tail, index - 1))
        );
    }
}