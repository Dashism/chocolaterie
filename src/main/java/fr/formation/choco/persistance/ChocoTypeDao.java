package fr.formation.choco.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.choco.metier.ChocoType;

/**
 * Gestion de toutes les requêtes SQL la table 'chocotype'.
 * 
 * @author Adminl
 *
 */
@Repository
public interface ChocoTypeDao extends JpaRepository<ChocoType, Integer> {

	ChocoType findByValue(String value);
	
	List<ChocoType> findByOriginId(Integer originId);
}
