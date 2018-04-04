package dhbw.lamazon.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * Entity-Klasse zur Kommunikation mit der Datenbank.
 * Auf diese Klasse darf nie direkt zugegriffen werden.
 * Über Fremdschlüssel sind passende User-Objekte verknüft, die mit der UserBean verwendet werden können.
 * Alternativ, kann die MessageBean dazu verwendet werden, neue Nachrichten zu erstellen und zu versenden.
 *
 * @author Marcel Wettach
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "NACHRICHT")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NACHRICHTEN_ID")
    private long id;
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EMPFAENGER")
    private User receiver;
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ABSENDER")
    private User sender;
    @NotNull
    @Column(name = "BETREFF")
    private String subject = "Kein Betreff";
    @NotNull
    @Column(name = "NACHRICHT")
    private String message;
    @Column(name = "DATUM")
    private Timestamp date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id);
        result = 31 * result;
        return result;
    }
}
