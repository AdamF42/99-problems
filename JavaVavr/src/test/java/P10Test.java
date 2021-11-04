import io.vavr.collection.List;

public class P10Test {


    public static void main(String[] args) {
        System.out.println(P10.encode(List.of()));
        System.out.println(P10.encode(null));
        System.out.println(P10.encode(List.of("a", "a", "a", "b", "b", "c")));
        System.out.println(P10.encode(List.of("b", "c", "c", "c", "b", "e","e","e", "d","d","d","d")));
    }
}
