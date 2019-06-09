package Controller;

import Model.Combat;
import Repository.CombatDAO;

/**
 * Classe para Controle do tipo Combat, onde ser�o contidos, valores e m�todos
 * para o mesmo.
 * 
 * @author Fernando G. Nogueira
 * @version 1.0
 */
public class CombatController {

	/**
	 * M�todo respons�vel para persistir entidade no sgbd
	 * 
	 * @author Fernando G. Nogueira
	 * @param entity Combat - Entidade a ser persistida
	 * @return Boolean - true-Sucesso/false-Falha
	 */
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
