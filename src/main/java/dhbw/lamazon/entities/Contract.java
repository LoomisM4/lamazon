package dhbw.lamazon.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * Entity-Klasse zur Kommunikation mit der Datenbank.
 * Auf diese Klasse darf nie direkt zugegriffen werden.
 *
 * @author Marcel Wettach
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "VERTRAG")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VERTRAGS_ID")
    private long id;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "KAEUFER")
    private User buyer;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "VERKAEUFER")
    private User seller;
    @NotNull
    @OneToOne
    @JoinColumn(name = "ARTIKEL")
    private Article article;
    @NotNull
    @Column(name = "DATUM")
    private Timestamp date;
}
