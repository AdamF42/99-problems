import io.vavr.collection.List;

import java.util.Objects;

import static io.vavr.API.*;
import static io.vavr.Patterns.$Cons;
import static io.vavr.Patterns.$Nil;

/**
 * <b>(**) Pack consecutive duplicates of list elements into sublists</b>
 * <p>If a list contains repeated elements they should be placed in separate sublists.</p>
 *
 * <pre>
 *     pack(Arrays.asList("a", "a", "a", "a", "b", "c", "c", "a", "a", "d", "e", "e", "e", "e"))
 *     [["a","a","a","a"],["b"],["c","c"],["a","a"],["d"],["e","e","e","e"]]
 * </pre>
 */
public class P09 {

    public static <T> List<List<T>> pack(List<T> elements) {
        return pack(elements, List.of(), List.of(), null);
    }

    private static <T> List<List<T>> pack(List<T> elements, List<List<T>> acc , List<T> pack, T prev) {
        return Match(elements).of(
                Case($(Objects::isNull), a -> null),
                Case($Nil(), a -> acc.append(pack)),
                Case($Cons($(i -> prev==null), $()), (a, tail) -> pack(tail, acc, List.of(a) ,a)),
                Case($Cons($(prev), $()), (a, tail) -> pack(tail, acc, pack.append(a), a)),
                Case($Cons($(), $()), (a, tail) -> pack(tail, acc.append(pack), List.of(a) ,a))
        );
    }

}