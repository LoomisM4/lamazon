package dhbw.lamazon.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Entity-Klasse zur Kommunikation mit der Datenbank.
 * Auf diese Klasse darf nie direkt zugegriffen werden.
 * Hierfür muss die UserBean verwendet werden.
 *
 * @author Marcel Wettach
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "favoriten")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EINTRAG")
    private long id = 0;
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BENUTZER")
    private User user;
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ARTIKEL")
    private Article article;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Favorite favorite = (Favorite) o;
        return id == favorite.id &&
                article.equals(favorite.article);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id);
        result = 31 * result;
        return result;
    }
}
