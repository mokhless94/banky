package banky.example.banky.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import banky.example.banky.Entity.Client;

public interface ClientRepository extends JpaRepository<Client,Long>  {
    
}
