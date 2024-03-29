package banky.example.banky.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity 
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name ="TYPE_CPTE",discriminatorType=DiscriminatorType.STRING,length=2)
public abstract class Compte implements Serializable {
    @Id
    private String codeCompte;
    private Date dateCreationDate;
    private double solde;
    @ManyToOne
    @JoinColumn(name="CODE_CLI")
    private Client client;
    @OneToMany(mappedBy="compte")
    private Collection<Operation> operations;
    public Compte() {
    }
    public Compte(String codeCompte, Date dateCreationDate, double solde, Client client) {
        this.codeCompte = codeCompte;
        this.dateCreationDate = dateCreationDate;
        this.solde = solde;
        this.client = client;
    }
    public String getCodeCompte() {
        return codeCompte;
    }
    public void setCodeCompte(String codeCompte) {
        this.codeCompte = codeCompte;
    }
    public Date getDateCreationDate() {
        return dateCreationDate;
    }
    public void setDateCreationDate(Date dateCreationDate) {
        this.dateCreationDate = dateCreationDate;
    }
    public double getSolde() {
        return solde;
    }
    public void setSolde(double solde) {
        this.solde = solde;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public Collection<Operation> getOperations() {
        return operations;
    }
    public void setOperations(Collection<Operation> operations) {
        this.operations = operations;
    }
    
}
