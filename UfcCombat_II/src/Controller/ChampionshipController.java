package Controller;

import Model.Championship;
import Repository.ChampionshipDAO;

/**
 * Classe para Controle do tipo Championship, onde serão contidos, valores e
 * métodos para o mesmo.
 * 
 * @author Fernando G. Nogueira
 * @version 1.0
 */
public class ChampionshipController {

	/**
	 * Método responsável para persistir entidade no sgbd
	 * 
	 * @author Fernando G. Nogueira
	 * @param entity Championship - Entidade a ser persistida
	 * @return Boolean - true-Sucesso/false-Falha
	 */
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
