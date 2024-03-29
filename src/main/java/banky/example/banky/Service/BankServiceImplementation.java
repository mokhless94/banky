package banky.example.banky.Service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import banky.example.banky.Entity.Compte;
import banky.example.banky.Entity.CompteCourant;
import banky.example.banky.Entity.Operation;
import banky.example.banky.Entity.Retrait;
import banky.example.banky.Entity.Versement;
import banky.example.banky.dao.CompteRepository;
import banky.example.banky.dao.OperationRepository;


@Service
@Transactional
public class BankServiceImplementation implements BankService{
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private OperationRepository operationRepository;
    @Override
    public Compte consulterCompte(String codeCpte) {
        Compte cp=compteRepository.findById(codeCpte).get();
        if(cp==null) throw new RuntimeException("Compte introuvable");
        return cp;
    }

    @Override
    public Page<Operation> listOperation(String codeCpte, int page, int size) {
        return operationRepository.listOperation(codeCpte, PageRequest.of(page, size));
    }

    @Override
    public void retirer(String codeCpte, double montant) {
        Compte cp= consulterCompte(codeCpte);
        double facilitesCaisse=0;
        if(cp instanceof CompteCourant)
            facilitesCaisse=((CompteCourant)cp).getDecouvert();
        if(cp.getSolde()+facilitesCaisse<montant)
            throw new RuntimeException("solde insiffisant");
        Retrait r= new Retrait( new Date(),montant,cp);
        operationRepository.save(r);
        cp.setSolde(cp.getSolde()-montant);
        compteRepository.save(cp);
        
    }

    @Override
    public void verser(String codeCpte, double montant) {
        Compte cp= consulterCompte(codeCpte);
        Versement v= new Versement( new Date(),montant,cp);
        operationRepository.save(v);
        cp.setSolde(cp.getSolde()+montant);
        compteRepository.save(cp);
    }

    @Override
    public void virement(String codeCpte1, String codeCpte2, Double montant) {
        if(codeCpte1.equals(codeCpte2))
			throw new RuntimeException("imposible le virement sur le meme compte");
        if(codeCpte2.isEmpty())
			throw new RuntimeException("Renseigner le Champ compte"); 
		if(montant==null)
			throw new RuntimeException("Renseigner le Champ Montant"); 
		retirer(codeCpte1, montant );
		verser(codeCpte2, montant);   
    }
    
}