package Model;

import java.util.ArrayList;

public class Championship {
	private int Id;
	private String Name;

	private ArrayList<Fighter> FighterList = new ArrayList<Fighter>();
	private ArrayList<Combat> CombatList = new ArrayList<Combat>();

	// Constructor
	public Championship(String name) {
		Name = name;
	}

	// GetSet
	public int GetId() {
		return Id;
	}

	public String GetName() {
		return Name;
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
			CombatList.add(new Combat(Name + " - Combate - " + idCombat, FighterList.get(i).getCategory(),
					FighterList.get(i), FighterList.get(i + 1)));
			idCombat++;
		}
	}

	// inicio de combate
	public void InvokeCombat() {
		for (int i = 0; i < CombatList.size(); i++) {
			CombatList.get(i).Play();
		}
	}
}
