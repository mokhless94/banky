package banky.example.banky.Entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("V")
public class Versement extends Operation {

    public Versement() {
    }

    public Versement(Date dateOperations, double montant, Compte compte) {
        super(dateOperations, montant, compte);
    }

    
    
}
