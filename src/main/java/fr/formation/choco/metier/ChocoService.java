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
		return this.dao.readAll();
	}

	public Object getOne(Integer id) {
		return this.dao.read(id);
	}

	public void addChoco(ChocoType chocoType) {
		this.dao.create(chocoType);
	}
	
	public void updateChoco(ChocoType chocoType) {
		this.dao.update(chocoType);
	}
	
	public void deleteChoco(Integer id) {
		this.dao.delete(id);
	}
}
