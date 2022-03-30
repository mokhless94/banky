package banky.example.banky.Entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {
    private double taux;

    public CompteEpargne() {
    }

    public CompteEpargne(String codeCompte, Date dateCreationDate, double solde, Client client, double taux) {
        super(codeCompte, dateCreationDate, solde, client);
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
    
}
