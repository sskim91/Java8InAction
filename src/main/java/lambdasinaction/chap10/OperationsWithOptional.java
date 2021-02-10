package lambdasinaction.chap10;

import java.util.*;

import static java.util.Optional.of;
import static java.util.Optional.empty;

public class OperationsWithOptional {

    public static void main(String... args) {
        System.out.println(max(of(3), of(5)));
        System.out.println(max(empty(), of(5)));

        Optional<Integer> opt1 = of(5);
        Optional<Integer> opt2 = opt1.or(() -> of(4));

        System.out.println(
        of(5).or(() -> of(4))
                          );
    }

    public static final Optional<Integer> max(Optional<Integer> i, Optional<Integer> j) {
         return i.flatMap(a -> j.map(b -> Math.max(a, b)));
    }

    public static Optional<Integer> stringToInt(String s) {
        try {
            //문자열을 정수로 변환할 수 있으면 정수로 변환된 값을 포함하는 Optional을 반환
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            //그렇지 않으면 빈 Optional을 반환한다.
            return Optional.empty();
        }
    }
}
