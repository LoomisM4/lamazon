package dhbw.lamazon.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Entity-Klasse zur Kommunikation mit der Datenbank.
 * Auf diese Klasse darf nie direkt zugegriffen werden.
 * Über Fremdschlüssel sind passende User-Objekte verknüft, die mit der UserBean verwendet werden können
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPFAENGER")
    private User receiver;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ABSENDER")
    private User sender;
    @NotNull
    @Column(name = "NACHRICHT")
    private String message;
    @NotNull
    @Column(name = "DATUM")
    private Date date;
}
