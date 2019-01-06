package fr.formation.choco.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.choco.persistance.ChocoOrderDao;

@Service
public class OrderService {

	@Autowired
	private ChocoOrderDao dao;

	public List<ChocoOrder> getChocoStocks() {
		return this.dao.findAll();
	}

	public ChocoOrder getChocoStock(Integer id) {
		return this.dao.getOne(id);
    }
    
    public ChocoOrder addOrUpdate(ChocoOrder choco) {
        return this.dao.save(choco);
    }

    public void delete(Integer id) {
        this.dao.deleteById(id);
    }
}
