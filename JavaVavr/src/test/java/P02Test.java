import io.vavr.collection.List;

public class P02Test {


    public static void main(String[] args) {
        //List<Integer> elements = List.of(1, 2, 4);
        List<String> elements = List.of("a", "b", "c", "d");
        System.out.println(P02.secondLast(elements));
    }
}
