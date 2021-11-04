import io.vavr.collection.List;

import java.util.Objects;

import static io.vavr.API.*;
import static io.vavr.Patterns.$Cons;
import static io.vavr.Patterns.$Nil;
import static io.vavr.Predicates.instanceOf;

/**
 * <b>(**) Eliminate consecutive duplicates of list elements</b>
 * <p>If a list contains repeated elements they should be replaced with a single copy of the element.
 * The order of the elements should not be changed.</p>
 * <p>
 * <pre>
 *     compress(Arrays.asList(a,a,a,a,b,c,c,a,a,d,e,e,e,e))
 *     [a,b,c,d,e]
 * </pre>
 */
public class P08 {

    public static <T> List<T> compress(List<T> elements) {
        return compress(elements, List.of(),null);
    }

    private static <T> List<T> compress(List<T> elements, List<T> acc , T prev) {
        return Match(elements).of(
                Case($(Objects::isNull), a -> null),
                Case($Nil(), a -> acc),
                Case($Cons($(prev), $()), (a, tail) -> compress(tail, acc, a)),
                Case($Cons($(), $()), (a, tail) -> compress(tail, acc.append(a), a))
        );
    }

}