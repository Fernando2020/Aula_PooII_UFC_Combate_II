package Controller;

import Model.Combat;
import Repository.CombatDAO;

public class CombatController {

	public boolean PersistEntityCombat(Combat entity) {
		CombatDAO combatDAO = new CombatDAO();
		try {
			combatDAO.inserir(entity);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
}
