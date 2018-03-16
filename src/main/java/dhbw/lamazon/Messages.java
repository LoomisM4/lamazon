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
public class Messages {
    @Getter
    private static List<String> messages = new ArrayList<>();

    public static void add(UserCommunication message) {
        Messages.getMessages().add(message.toString());
    }

    public static void clear() {
        Messages.getMessages().clear();
    }
}
