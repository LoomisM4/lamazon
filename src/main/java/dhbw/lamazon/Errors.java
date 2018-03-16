package dhbw.lamazon;

import dhbw.lamazon.enums.UserCommunication;
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

    public static void add(UserCommunication error) {
        Errors.getErrors().add(error.toString());
    }

    public static void clear() {
        Errors.getErrors().clear();
    }

    public static boolean isEmpty() {
        return Errors.getErrors().isEmpty();
    }
}
