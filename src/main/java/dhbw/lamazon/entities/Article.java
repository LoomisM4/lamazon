package dhbw.lamazon.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entity-Klasse zur Kommunikation mit der Datenbank.
 * Auf diese Klasse darf nie direkt zugegriffen werden.
 * Hierfür muss die passende Bean ArticleBean verwendet werden.
 *
 * @author Marcel Wettach
 */
@Data
@NoArgsConstructor
@Table(name = "ARTIKEL")
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id = 0;
    @NotNull
    @Column(name = "TITEL")
    private String title;
    @NotNull
    @Column(name = "BESCHREIBUNG")
    private String description;
    @NotNull
    @Column(name = "PREIS")
    private double price;
    @NotNull
    @Column(name = "ERSTELLER")
    private long user;

    /**
     * liefer die Beschreibung des Artikels in kurzform, falls diese mehr als 150 Zeichen enthält
     *
     * @return eine Verkürzte Beschreibung, die mit '...' endet
     */
    public String getShortDescription() {
        if (this.description.length() > 150) {
            return this.description.substring(0, 150) + "...";
        }
        return this.description;
    }
}
