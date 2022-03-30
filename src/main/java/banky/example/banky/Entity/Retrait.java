package banky.example.banky.Entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation {

    public Retrait() {
    }

    public Retrait(Date dateOperations, double montant, Compte compte) {
        super(dateOperations, montant, compte);
    }
    
}
