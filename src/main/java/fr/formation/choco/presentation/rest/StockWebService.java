package fr.formation.choco.presentation.rest;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

import fr.formation.choco.metier.StockService;
import fr.formation.choco.metier.ChocoStock;

@RestController
@RequestMapping("/stock")
@Transactional(readOnly=true)
public class StockWebService {

    @Autowired
	private StockService service;

	@GetMapping
	public List<ChocoStock> list() {
		return this.service.getChocoStocks();
    }
    
    @GetMapping("/{id}")
    public ChocoStock read(@PathVariable Integer id) {
        final ChocoStock choco = this.service.getChocoStock(id);
        Hibernate.initialize(choco);
        return choco;
    }

    @PostMapping
    public ChocoStock create(@RequestBody ChocoStock choco) {
        return this.service.addOrUpdate(choco);
    }

    @PutMapping("/{id}")
    public ChocoStock update(@PathVariable Integer id, @RequestBody ChocoStock choco) {
        return this.service.addOrUpdate(choco);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        this.service.delete(id);
    }
}
