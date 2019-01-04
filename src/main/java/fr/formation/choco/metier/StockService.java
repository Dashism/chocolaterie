package fr.formation.choco.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.choco.persistance.ChocoStockDao;

@Service
public class StockService {

	@Autowired
	private ChocoStockDao dao;

	public List<ChocoStock> getChocoStocks() {
		return this.dao.findAll();
	}

	public ChocoStock getChocoStock(Integer id) {
		return this.dao.getOne(id);
	}
}
