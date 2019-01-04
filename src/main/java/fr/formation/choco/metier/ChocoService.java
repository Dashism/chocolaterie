package fr.formation.choco.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.choco.persistance.ChocoTypeDao;

@Service
public class ChocoService {

	@Autowired
	private ChocoTypeDao dao;

	public List<ChocoType> getChocoTypes() {
		return this.dao.findAll();
	}

	public Object getOne(Integer id) {
		return this.dao.getOne(id);
	}

	public void addChoco(ChocoType chocoType) {
		this.dao.save(chocoType);
	}
	
	public void updateChoco(ChocoType chocoType) {
		this.dao.save(chocoType);
	}
	
	public void deleteChoco(Integer id) {
		this.dao.deleteById(id);
	}
}
