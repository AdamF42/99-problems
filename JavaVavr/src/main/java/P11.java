import io.vavr.Tuple;
import io.vavr.collection.List;

import java.util.Objects;

import static io.vavr.API.*;
import static io.vavr.Patterns.$Tuple2;

/**
 * Modify the result of problem 10 in such a way that if an element has no duplicates it is simply
 * copied into the result list. Only elements with duplicates are transferred as (N E) lists.
 * Example:
 * (encode-modified '(a a a a b c c a a d e e e e))
 * ((4 A) B (2 C) (2 A) D (4 E))
 */
public class P11 {

    public static <T> List<Tuple> encode_modified(List<T> elements) {
        List<Tuple> packedElements = P10.encode(elements);
        return Match(packedElements).of(
                Case($(Objects::isNull), a -> null),
                Case($(), P11::encode_modified_not_null)
        );

    }

    public static <T> List<Tuple> encode_modified_not_null(List<Tuple> elements) {
        return elements.map(elem ->
                Match(elem).of(
                        Case($Tuple2($(1), $()), (_1, _2) -> Tuple.of(_2)),
                        Case($Tuple2($(), $()), Tuple::of)
                )
        );
    }
}