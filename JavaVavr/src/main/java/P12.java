import io.vavr.Tuple;
import io.vavr.collection.List;

import java.util.Objects;

import static io.vavr.API.*;
import static io.vavr.Patterns.*;

/**
 * Decode a run-length encoded list.
 * <p>
 * Given a run-length code list generated as specified in problem 11. Construct its uncompressed version.
 * <p>
 * Example in Haskell:
 * <p>
 * λ> decodeModified
 * [Multiple 4 'a',Single 'b',Multiple 2 'c',
 * Multiple 2 'a',Single 'd',Multiple 4 'e']
 * "aaaabccaadeeee"
 */
public class P12 {

    public static <T> List<T> decodeModified(List<Tuple> elements) {
        return Match(elements).of(
                Case($(Objects::isNull), a -> null),
                Case($Nil(), List.of()),
                Case($(), P12::decodeModifiedNotNull)
        );

    }

    private static <T> List<T> decodeModifiedNotNull(List<Tuple> elements) {
        return decodeModifiedNotNull(elements, List.of());
    }

    private static <T> List<T> decodeModifiedNotNull(List<Tuple> elements, List<T> acc) {
        return Match(elements).of(
                Case($Cons($(), $Nil()), (a, tail) -> acc.appendAll(expand(a))),
                Case($Cons($(), $()), (a, tail) -> decodeModifiedNotNull(tail, acc.appendAll(expand(a))))
        );
    }

    private static <T> List<T> expand(Tuple t) {
        return (List<T>) Match(t).of(
                Case($Tuple2($(), $()), (_1, _2) -> nCopies((Integer) _1, _2, List.of())),
                Case($Tuple1($()), e -> List.of(e))
        );
    }

    private static <T> List<T> nCopies(Integer n, T obj, List<T> acc) {
        return Match(n).of(
                Case($(1), a -> acc),
                Case($(), a -> nCopies(a - 1, obj, acc.append(obj)))
        );
    }
}