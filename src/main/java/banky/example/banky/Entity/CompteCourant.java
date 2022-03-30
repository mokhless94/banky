package banky.example.banky.Entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {
    private double decouvert;

    public CompteCourant() {
    }

    public CompteCourant(String codeCompte, Date dateCreationDate, double solde, Client client, double decouvert) {
        super(codeCompte, dateCreationDate, solde, client);
        this.decouvert = decouvert;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }
     
    

    
    
}