package dhbw.lamazon.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BENUTZER")
public class Benutzer {
    @Id
    @NotNull
    @Column(name = "BENUTZERNAME")
    private String benutzername;
    @NotNull
    @Column(name = "PASSWORT")
    private String passwort;
}
