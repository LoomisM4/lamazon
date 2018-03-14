package dhbw.lamazon;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * beinhaltet statische Methoden, mit denen eine Liste vom Typ String befüllt oder geleert werden kann.
 *
 * @author Marcel Wettach
 */
public class Messages {
    @Getter
    private static List<String> messages = new ArrayList<>();

    public static void add(String message) {
        Messages.getMessages().add(message);
    }

    public static void clear() {
        Messages.getMessages().clear();
    }
}
