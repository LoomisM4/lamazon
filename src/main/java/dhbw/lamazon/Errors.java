package dhbw.lamazon;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * beinhaltet statische Methoden, mit denen eine Liste vom Typ String befüllt oder geleert werden kann.
 *
 * @author Marcel Wettach
 */
public class Errors {
    @Getter
    private static List<String> errors = new ArrayList<>();

    public static void add(String error) {
        Errors.getErrors().add(error);
    }

    public static void clear() {
        Errors.getErrors().clear();
    }

    public static boolean isEmpty() {
        return Errors.getErrors().isEmpty();
    }
}
