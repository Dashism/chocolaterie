package fr.formation.choco.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.choco.metier.ChocoStock;

/**
 * Gestion de toutes les requêtes SQL la table 'choco_type'.
 * 
 * @author Adminl
 *
 */
@Repository
public interface ChocoStockDao extends JpaRepository<ChocoStock, Integer> {

}
