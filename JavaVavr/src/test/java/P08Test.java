import io.vavr.collection.List;

public class P08Test {


    public static void main(String[] args) {
        System.out.println(P08.compress(List.of()));
        System.out.println(P08.compress(null));
        System.out.println(P08.compress(List.of(1, 1, 1, 2, 2, 3)));
    }
}
