package fr.formation.choco.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.choco.metier.ChocoOrigin;

public interface ChocoOriginDao extends JpaRepository<ChocoOrigin, Integer> {

}
