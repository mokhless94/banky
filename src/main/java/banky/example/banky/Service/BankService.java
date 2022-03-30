package banky.example.banky.Service;

import org.springframework.data.domain.Page;

import banky.example.banky.Entity.Compte;
import banky.example.banky.Entity.Operation;


public interface BankService {
    public Compte consulterCompte(String codeCpte);
    public void verser(String codeCpte,double montant);
    public void retirer(String codeCpte,double montant);
    public void virement(String codeCpte1,String codeCpte2,Double montant);
    public Page<Operation> listOperation(String codeCpte,int page,int size); 
}   
