import io.vavr.collection.List;

public class P06Test {


    public static void main(String[] args) {
        System.out.println(P06.isPalindrome(List.of(1, 2, 4)));
        System.out.println(P06.isPalindrome(List.of()));
        System.out.println(P06.isPalindrome(null));
        System.out.println(P06.isPalindrome(List.of(1, 2, 3, 2, 1)));
        System.out.println(P06.isPalindrome(List.of(1, 2, 2, 1)));
    }
}
