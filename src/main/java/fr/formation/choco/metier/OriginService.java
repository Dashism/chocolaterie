package fr.formation.choco.metier;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.choco.persistance.ChocoOriginDao;

@Service
public class OriginService {

	@Autowired
	private ChocoService chocoService;
	
	@Autowired
	private ChocoOriginDao originDao;
	
	public Map<ChocoOrigin, List<ChocoType>> getAllTypesByOrigin() {
		// IMPORTANT : Utilisation d'une implémentation de Map permettant de conserver
		// l'ordre dans lequel on put les éléments !
		Map<ChocoOrigin, List<ChocoType>> result = new LinkedHashMap<ChocoOrigin, List<ChocoType>>();
		// Récupération de toutes les origines.
		List<ChocoOrigin> origins = this.originDao.findAll();
		// Tri alphabétique des origines sur leur texte.
//		Collections.sort(origins, new Comparator<ChocoOrigin>() {
//		    @Override
//		    public int compare(ChocoOrigin origin1, ChocoOrigin origin2) {
//		        return origin1.getText().compareToIgnoreCase(origin2.getText());
//		    }
//		});
		// Cette ligne de code utilise les expressions Lambda, et est équivalente au code en commentaire au dessus.
		Collections.sort(origins, (origin1, origin2) -> origin1.getText().compareToIgnoreCase(origin2.getText()));
		// On parcourt les origines dans le bon ordre pour remplir la Map avec les types de chocolats associés.
		for (ChocoOrigin origin : origins) {
			List<ChocoType> types = this.chocoService.getAllByOrigin(origin.getId());
			if (types != null && !types.isEmpty()) {
				result.put(origin, types);
			}
		}
		return result;
	}
}
