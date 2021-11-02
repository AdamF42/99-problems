import io.vavr.collection.List;

public class P04Test {


    public static void main(String[] args) {
        List<String> elements = List.of("a", "b", "c", "d");
        System.out.println(P04.length(elements));
        List<String> emptyList = List.of();
        System.out.println(P04.length(emptyList));

    }
}
