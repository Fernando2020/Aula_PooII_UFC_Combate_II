package Model;

import java.util.ArrayList;
import Controller.CombatController;
import View.View;

public class Championship {
	private int Id;
	private String Name;
	private String Ano;

	private ArrayList<Fighter> FighterList = new ArrayList<Fighter>();
	private ArrayList<Combat> CombatList = new ArrayList<Combat>();
	private CombatController combatController = new CombatController();

	// Constructor
	public Championship(String name, String ano) {
		Name = name;
		Ano = ano;
	}

	public Championship(int id, String name, String ano) {
		Id = id;
		Name = name;
		Ano = ano;
	}

	public Championship() {

	}

	// GetSet
	public int GetId() {
		return Id;
	}

	public void SetId(int id) {
		Id = id;
	}

	public String GetName() {
		return Name;
	}

	public void SetName(String name) {
		Name = name;
	}

	public String GetAno() {
		return Ano;
	}

	public void SetAno(String ano) {
		Ano = ano;
	}

	public ArrayList<Fighter> GetFighterList() {
		return FighterList;
	}

	public void SetFighterList(ArrayList<Fighter> fighterList) {
		FighterList = fighterList;
	}

	public ArrayList<Combat> GetCombatList() {
		return CombatList;
	}

	// lista de combate
	public void SetCombat() {
		int idCombat = 1;
		for (int i = 0; i < FighterList.size(); i += 2) {
			CombatList.add(new Combat(Name + " - Combate - " + idCombat, Id, FighterList.get(i).GetCategory(),
					FighterList.get(i), FighterList.get(i + 1)));
			idCombat++;
		}
	}

	// inicio de combate
	public void InvokeCombat() {
		View.ExecucaoChampionship(Id, Name, Ano);
		for (int i = 0; i < CombatList.size(); i++) {
			CombatList.get(i).Play();
			combatController.PersistEntityCombat(CombatList.get(i));
		}
	}
}
