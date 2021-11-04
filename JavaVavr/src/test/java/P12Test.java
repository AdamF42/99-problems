import io.vavr.collection.List;

public class P12Test {


    public static void main(String[] args) {
        System.out.println(P12.decodeModified(List.of()));
        System.out.println(P12.decodeModified(null));
        System.out.println(P12.decodeModified(P11.encode_modified(List.of("b", "c", "c", "c", "b", "e", "e", "e", "d", "d", "d", "d"))));
    }
}
