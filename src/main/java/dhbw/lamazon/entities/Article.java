package dhbw.lamazon.entities;

import dhbw.lamazon.Category;
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
    @Column(name = "ARTIKELNUMMER")
    private long id = 0;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VERKAEUFER")
    private User user;
    @NotNull
    @Column(name = "BEZEICHNUNG")
    private String title;
    @NotNull
    @Column(name = "ARTIKELBESCHREIBUNG")
    private String description;
    @NotNull
    @Column(name = "PREIS")
    private double price;
    @Column(name = "FARBE")
    private String color;
    @Column(name = "BILD")
    private byte[] image;
    @Column(name = "KATEGORIE")
    private Category category;

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
