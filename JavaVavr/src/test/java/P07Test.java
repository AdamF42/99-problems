import io.vavr.collection.List;

public class P07Test {


    public static void main(String[] args) {
        System.out.println(P07.flatten(List.of(List.of(1, 2), List.of(3), 4)));
        System.out.println(P07.flatten(List.of()));
        System.out.println(P07.flatten(null));
        System.out.println(P07.flatten(List.of(1, 2, 3, 2, 1)));
        System.out.println(P07.flatten(List.of(1, 2, 2, 1)));
    }
}
