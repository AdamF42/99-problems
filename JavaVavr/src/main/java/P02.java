import io.vavr.collection.List;

import static io.vavr.API.*;
import static io.vavr.Patterns.$Cons;
import static io.vavr.Patterns.$Nil;

/**
 * (*) Find the second last element of a list.
 */
public class P02 {

    public static <T> T secondLast(List<T> elements) {
        return Match(elements).of(
                Case($Cons($(), $Cons($(), $Nil())), (a, tail) -> a),
                Case($Cons($(), $()), (a, tail) -> secondLast(tail))
        );
    }
}