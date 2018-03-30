package dhbw.lamazon;

import dhbw.lamazon.enums.UserCommunication;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * beinhaltet statische Methoden, mit denen eine Liste vom Benachrichtigungen befüllt oder geleert werden kann.
 *
 * @author Marcel Wettach
 */
public class Messages {
    @Getter
    private static List<UserCommunication> messages = new ArrayList<>();

    public static void add(UserCommunication message) {
        Messages.getMessages().add(message);
    }

    public static void clear() {
        Messages.getMessages().clear();
    }

    public static boolean isEmpty() {
        return Errors.getErrors().isEmpty();
    }
}
