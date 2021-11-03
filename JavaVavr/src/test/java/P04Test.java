import io.vavr.collection.List;

public class P04Test {


    public static void main(String[] args) {
        System.out.println(P04.length(List.of("a", "b", "c", "d")));
        System.out.println(P04.length(List.of()));
        System.out.println(P04.length(null));

    }
}
