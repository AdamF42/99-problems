import io.vavr.collection.List;

public class P05Test {


    public static void main(String[] args) {
        System.out.println(P05.reverse(List.of(1, 2, 4)));
        System.out.println(P05.reverse(List.of()));
        System.out.println(P05.reverse(null));
    }
}
