package Controller;

import Model.Fighter;
import Model.FighterChampionship;

import java.util.ArrayList;

import Model.Championship;
import Repository.FighterChampionshipDAO;

/**
 * Classe para Controle do tipo FighterChampionship, onde ser�o contidos,
 * valores e m�todos para o mesmo.
 * 
 * @author Fernando G. Nogueira.
 * @version 1.0.
 */
public class FighterChampionshipController {

	/**
	 * M�todo respons�vel para persistir entidade no sgbd.
	 * 
	 * @author Fernando G. Nogueira.
	 * @param listEntity - Lista de Entidade a ser persistida.
	 * @param entity     Championship - Entidade a ser persistida.
	 * @return Boolean - true-Sucesso/false-Falha.
	 */
	public boolean PersistEntityFighterChampionship(ArrayList<Fighter> listEntity, Championship entity) {
		FighterChampionshipDAO fighterChampionshipDAO = new FighterChampionshipDAO();
		FighterChampionship fighterChampionship;
		try {
			int i = 0;
			for (Fighter fighter : listEntity) {
				fighterChampionship = new FighterChampionship();

				fighterChampionship.SetId(i);
				fighterChampionship.SetIdChampionship(entity.GetId());
				fighterChampionship.SetIdFighter(fighter.GetId());

				fighterChampionshipDAO.inserir(fighterChampionship);
				i++;
			}
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
}
