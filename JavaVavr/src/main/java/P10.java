import io.vavr.Tuple;
import io.vavr.collection.List;

import java.util.Objects;

import static io.vavr.API.*;
import static io.vavr.Patterns.$Cons;
import static io.vavr.Patterns.$Nil;

/**
 * (*) Run-length encoding of a list. Use the result of problem P09 to implement the so-called run-length
 * encoding data compression method. Consecutive duplicates of elements are encoded as lists (N E) where N
 * is the number of duplicates of the element E.
 * Example:
 * (encode '(a a a a b c c a a d e e e e))
 * ((4 A) (1 B) (2 C) (2 A) (1 D)(4 E)
 */
public class P10 {

    public static <T> List<Tuple> encode(List<T> elements) {
        List<List<T>> packedElements = P09.pack(elements);
        return encode(packedElements, List.of());
    }

    private static <T> List<Tuple> encode(List<List<T>> elements, List<Tuple> acc) {
        return Match(elements).of(
                Case($Nil(), a -> List.of()),
                Case($(Objects::isNull), a -> null),
                Case($Cons($Nil(), $Nil()), (a, tail) -> List.of()),
                Case($Cons($(), $Nil()), (a, tail) -> acc.append(Tuple(P04.length(a), a.get()))),
                Case($Cons($(), $()), (a, tail) -> encode(tail, acc.append(Tuple(P04.length(a), a.get()))))
        );
    }

}