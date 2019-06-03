package Controller;

import Repository.FighterDAO;
import Model.Fighter;

public class FighterController {

	public void PersistEntityFighter(Fighter entity) {
		FighterDAO fighterDAO = new FighterDAO();
		fighterDAO.inserir(entity);
	}
}
