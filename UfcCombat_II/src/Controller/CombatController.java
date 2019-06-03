package Controller;

import Model.Combat;
import Repository.CombatDAO;

public class CombatController {

	public void PersistEntityCombat(Combat entity) {
		CombatDAO combatDAO = new CombatDAO();
		combatDAO.inserir(entity);
	}
}
