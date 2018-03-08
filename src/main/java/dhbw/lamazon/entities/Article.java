package dhbw.lamazon.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entity-Klasse zur Kommunikation mit der Datenbank.
 * Auf diese Klasse darf nie direkt zugegriffen werden.
 * Hierfür muss die passende Bean ArticleBean verwendet werden.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    public String getShortDescription() {
        if (this.description.length() > 150) {
            return this.description.substring(0, 150) + "...";
        }
        return this.description;
    }
}
