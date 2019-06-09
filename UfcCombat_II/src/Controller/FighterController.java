package Controller;

import Repository.FighterDAO;
import Model.Fighter;

public class FighterController {

	public boolean PersistEntityFighter(Fighter entity) {
		FighterDAO fighterDAO = new FighterDAO();
		try {
			fighterDAO.inserir(entity);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
}
