package dhbw.lamazon.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
}
