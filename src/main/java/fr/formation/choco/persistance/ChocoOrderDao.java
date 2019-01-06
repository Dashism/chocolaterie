package fr.formation.choco.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.formation.choco.metier.ChocoOrder;

/**
 * Gestion de toutes les requêtes SQL la table 'choco_order'.
 * 
 * @author Adminl
 *
 */
@Repository
public interface ChocoOrderDao extends JpaRepository<ChocoOrder, Integer> {

}
