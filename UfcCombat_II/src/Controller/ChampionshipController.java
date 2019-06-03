package Controller;

import Model.Championship;
import Repository.ChampionshipDAO;

public class ChampionshipController {

	public void PersistEntityChampionship(Championship entity) {
		ChampionshipDAO championshipDAO = new ChampionshipDAO();
		championshipDAO.inserir(entity);
	}
}
