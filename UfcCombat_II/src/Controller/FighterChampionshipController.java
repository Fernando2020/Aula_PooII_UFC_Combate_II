package Controller;

import Model.Fighter;
import Model.FighterChampionship;

import java.util.ArrayList;

import Model.Championship;
import Repository.FighterChampionshipDAO;

public class FighterChampionshipController {
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
