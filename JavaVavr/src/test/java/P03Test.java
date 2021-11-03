import io.vavr.collection.List;

public class P03Test {


    public static void main(String[] args) {
        //List<Integer> elements = List.of(1, 2, 4);
        List<String> elements = List.of("a", "b", "c", "d");
        System.out.println(P03.kth(elements, 1));
        System.out.println(P03.kth(elements, 3));
        System.out.println(P03.kth(List.of(), 1));
        System.out.println(P03.kth(elements, -1));
        System.out.println(P03.kth(null, 1));
        System.out.println(P03.kth(elements, 5));
    }
}
