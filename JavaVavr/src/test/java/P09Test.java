import io.vavr.collection.List;

public class P09Test {


    public static void main(String[] args) {
        System.out.println(P09.pack(List.of()));
        System.out.println(P09.pack(null));
        System.out.println(P09.pack(List.of(1, 1, 1, 2, 2, 3)));
        System.out.println(P09.pack(List.of(2, 3, 3, 3, 2, 7,7,7, 4,4,4,4)));
    }
}
