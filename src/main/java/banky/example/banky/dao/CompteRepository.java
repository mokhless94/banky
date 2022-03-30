package banky.example.banky.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import banky.example.banky.Entity.Compte;


public interface CompteRepository extends JpaRepository <Compte,String>{
    
}
