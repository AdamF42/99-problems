import io.vavr.collection.List;

import static io.vavr.API.*;
import static io.vavr.Patterns.$Cons;
import static io.vavr.Patterns.$Nil;

/**
 * (*) Find the last element of a list.
 */
public class P01 {

    public static <T> T last(List<T> elements) {
        return Match(elements).of(
                Case($Cons($(), $Nil()), (a, tail) -> a),
                Case($Cons($(), $()), (a, tail) -> last(tail))
        );
    }
}
