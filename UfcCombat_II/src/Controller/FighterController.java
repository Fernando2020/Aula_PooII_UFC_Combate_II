package Controller;

import Repository.FighterDAO;
import Model.Fighter;

/**
 * Classe para Controle do tipo Fighter, onde serão contidos, valores e métodos
 * para o mesmo.
 * 
 * @author Fernando G. Nogueira
 * @version 1.0
 */
public class FighterController {

	/**
	 * Método responsável para persistir entidade no sgbd
	 * 
	 * @author Fernando G. Nogueira
	 * @param entity Fighter - Entidade a ser persistida
	 * @return Boolean - true-Sucesso/false-Falha
	 */
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
