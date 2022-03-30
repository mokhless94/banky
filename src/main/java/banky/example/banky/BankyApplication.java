package banky.example.banky;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import banky.example.banky.Entity.Client;
import banky.example.banky.Entity.Compte;
import banky.example.banky.Entity.CompteCourant;
import banky.example.banky.Entity.CompteEpargne;
import banky.example.banky.Entity.Operation;
import banky.example.banky.Entity.Retrait;
import banky.example.banky.Entity.Versement;
import banky.example.banky.Service.BankService;
import banky.example.banky.dao.ClientRepository;
import banky.example.banky.dao.CompteRepository;
import banky.example.banky.dao.OperationRepository;

@SpringBootApplication
// @EnableAutoConfiguration
public class BankyApplication   {
	// @Autowired
    //  private ClientRepository clientRepository;
    //  @Autowired
    //  private CompteRepository compteRepository;
    //  @Autowired
    //  private OperationRepository operationRepository;
    //  @Autowired
    //  private BankService bankService;
	public static void main(String[] args) {
		SpringApplication.run(BankyApplication.class, args);
	}
	// @Override
	// public void run(String... args) throws Exception {
	// 	// Client c1 =clientRepository.save(new Client("mokhless", "mokhless@gmail.com"));
	// 	// Client c2 =clientRepository.save(new Client("assil", "assil@gmail.com"));
		
	// 	// Compte cp1 =compteRepository.save(new CompteCourant("c1", new Date(), 5000, c1, 2000));
	// 	// Compte cp2 =compteRepository.save(new CompteEpargne("c2", new Date(), 9000, c2, 5.5));
		
	// 	// Operation o1 =operationRepository.save(new Versement(new Date(), 1500, cp2));
	// 	// Operation o3 =operationRepository.save(new Versement(new Date(), 500, cp2));
	// 	// Operation o4 =operationRepository.save(new Versement(new Date(), 100, cp2));
	// 	// Operation o5 =operationRepository.save(new Versement(new Date(), 150, cp2));
	// 	// Operation o6 =operationRepository.save(new Versement(new Date(), 1600, cp2));
	// 	// Operation o2 =operationRepository.save(new Retrait(new Date(), 1500, cp1));		
	// }

}
