package Controller;

import Model.Championship;
import Repository.ChampionshipDAO;

public class ChampionshipController {

	public boolean PersistEntityChampionship(Championship entity) {
		ChampionshipDAO championshipDAO = new ChampionshipDAO();
		try {
			championshipDAO.inserir(entity);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
}
