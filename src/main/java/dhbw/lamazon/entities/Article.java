package dhbw.lamazon.entities;

import dhbw.lamazon.enums.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.imageio.ImageIO;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

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
    @ManyToOne(fetch = FetchType.EAGER)
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
    @Lob
    @Column(name = "BILD")
    private byte[] image;
    @Enumerated(EnumType.STRING)
    @Column(name = "KATEGORIE")
    private Category category;
    @OneToMany(mappedBy = "article", fetch = FetchType.EAGER)
    private List<Favorite> favoriteOf;

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

    public void setCategory(Category c) {
        this.category = c;
    }

    public BufferedImage getImage() {
        if (image != null) {
            ByteArrayInputStream stream = new ByteArrayInputStream(image);
            try {
                return ImageIO.read(stream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String toString() {
        return this.title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article artikel = (Article) o;
        return id == artikel.id &&
                title.equals(artikel.title) &&
                description.equals(artikel.description);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id);
        result = 31 * result;
        return result;
    }
}
