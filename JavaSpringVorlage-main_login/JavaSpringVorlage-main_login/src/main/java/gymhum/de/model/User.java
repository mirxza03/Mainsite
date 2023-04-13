package gymhum.de.model;

// import java.validation.constraints;
import java.time.LocalDate;
import javax.validation.constraints.*;

public class User {
    // https://javaee.github.io/javaee-spec/javadocs/javax/validation/constraints/NotBlank.html
    // Das kommentierte Element darf nicht null sein und muss mindestens ein Zeichen enthalten,
    // das nicht aus einem Leerzeichen besteht. Akzeptiert ebenfalls CharSequence.
    @NotBlank(message = "Vorname ist erforderlich")
    String vorname;

    @NotBlank(message = "Nachname ist erforderlich")
    String nachname;

    // https://docs.oracle.com/javaee/7/api/javax/validation/constraints/NotNull.html
    // Eine übliche Spring-Anmerkung, um zu erklären, dass annotierte Elemente nicht null sein können.
    @NotNull(message = "Geburtsdatum ist erforderlich")
    String geburtstag;

    @NotBlank(message = "E-Mail-Adresse ist erforderlich")
    @Email(message = "E-Mail-Adresse ist ungültig")
    String email;

    @NotNull(message = "Postleitzahl ist erforderlich")
    Integer postleitzahl;

    @AssertTrue(message = "AGB müssen akzeptiert werden")
    Boolean agbAkzeptiert;

    public User(String vorname, String nachname, String geburtstag, String email, Integer postleitzahl, Boolean agbAkzeptiert){
        this.setNachname(nachname);
        this.setVorname(vorname);
        this.setGeburtstag(geburtstag);
        this.setEmail(email);
        this.setPostleitzahl(postleitzahl);
        this.setAgbAkzeptiert(agbAkzeptiert);
    }

    // Setter Methoden
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setGeburtstag(String geburtstag) {
        this.geburtstag = geburtstag;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPostleitzahl(Integer postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    public void setAgbAkzeptiert(Boolean agbAkzeptiert) {
        this.agbAkzeptiert = agbAkzeptiert;
    }

    // Getter Methoden
    public String getNachname() {
        return this.nachname;
    }

    public String getVorname() {
        return this.vorname;
    }

    public String getGeburtstag() {
        return this.geburtstag;
    }

    public String getEmail() {
        return this.email;
    }

    public Integer getPostleitzahl() {
        return this.postleitzahl;
    }

    public Boolean getAgbAkzeptiert() {
        return this.agbAkzeptiert;
    }
}





