import io.vavr.collection.List;

public class P01Test {


    public static void main(String[] args) {
        //List<Integer> elements = List.of(1, 2, 4);
        List<String> elements = List.of("a", "b", "c");
        System.out.println(P01.last(elements));
        System.out.println(P02.secondLast(List.of()));
        System.out.println(P02.secondLast(null));
    }
}
