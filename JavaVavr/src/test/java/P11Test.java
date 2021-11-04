import io.vavr.collection.List;

public class P11Test {


    public static void main(String[] args) {
        System.out.println(P11.encode_modified(List.of()));
        System.out.println(P11.encode_modified(null));
        System.out.println(P11.encode_modified(List.of("a", "a", "a", "b", "b", "c")));
        System.out.println(P11.encode_modified(List.of("b", "c", "c", "c", "b", "e","e","e", "d","d","d","d")));
    }
}
