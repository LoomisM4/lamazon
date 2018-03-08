package dhbw.lamazon.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entity-Klasse zur Kommunikation mit der Datenbank.
 * Auf diese Klasse darf nie direkt zugegriffen werden.
 * Hierfür muss die passende Bean UserBean verwendet werden.
 *
 * @author Marcel Wettach
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "BENUTZER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id = 0;
    @NotNull
    @Column(name = "BENUTZERNAME")
    private String benutzername;
    @NotNull
    @Column(name = "EMAIL")
    private String email;
    @NotNull
    @Column(name = "PASSWORT")
    private String passwort;
    @NotNull
    @Column(name = "VORNAME")
    private String vorname;
    @NotNull
    @Column(name = "NACHNAME")
    private String nachname;
    @NotNull
    @Column(name = "STRASSE")
    private String strasse;
    @NotNull
    @Column(name = "HAUSNUMMER")
    private String hausnr;
    @NotNull
    @Column(name = "PLZ")
    private long plz;
    @NotNull
    @Column(name = "ORT")
    private String ort;
}
