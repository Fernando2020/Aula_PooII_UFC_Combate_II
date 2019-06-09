package Model;

import View.View;

public class Combat {
	private int Id;
	private String Name;
	private int IdChampionship;
	private String Category;
	private Fighter First;
	private Fighter Second;
	private Fighter Winner;
	private Fighter Loser;
	private boolean KO;
	private int PointWinner;
	private int PointLoser;
	private int IdFirst;
	private int IdSecond;
	private int IdWinner;
	private int IdLoser;
	private String NameFirst;
	private String NameSecond;
	private String NameWinner;
	private String NameLoser;

	// Constructor
	public Combat(String name, int idChampionship, String category, Fighter first, Fighter second) {
		Name = name;
		IdChampionship = idChampionship;
		Category = category;
		First = first;
		Second = second;
		KO = false;
	}

	public Combat(int id, String name, String category, int idChampionship, int idUm, int idDois, int idWinner,
			int idLoser, boolean ko, int pointWinner, int pointLoser) {
		Id = id;
		Name = name;
		Category = category;
		IdChampionship = idChampionship;
		IdFirst = idUm;
		IdSecond = idDois;
		IdWinner = idWinner;
		IdLoser = idLoser;
		KO = ko;
		PointWinner = pointWinner;
		PointLoser = pointLoser;
	}

	public Combat() {

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

	public int GetIdChampionship() {
		return IdChampionship;
	}

	public void SetIdChampionship(int idChampionship) {
		IdChampionship = idChampionship;
	}

	public String GetCategory() {
		return Category;
	}

	public void SetCategory(String category) {
		Category = category;
	}

	public Fighter GetFirst() {
		return First;
	}

	public void SetFirst(Fighter first) {
		First = first;
	}

	public Fighter GetSecond() {
		return Second;
	}

	public void SetSecond(Fighter second) {
		Second = second;
	}

	public Fighter GetWinner() {
		return Winner;
	}

	public void SetWinner(Fighter winner) {
		Winner = winner;
	}

	public Fighter GetLoser() {
		return Loser;
	}

	public void SetLoser(Fighter loser) {
		Loser = loser;
	}

	public boolean IsKO() {
		return KO;
	}

	public void SetKO(boolean kO) {
		KO = kO;
	}

	public int GetPointWinner() {
		return PointWinner;
	}

	public void SetPointWinner(int pointWinner) {
		PointWinner = pointWinner;
	}

	public int GetPointLoser() {
		return PointLoser;
	}

	public void SetPointLoser(int pointLoser) {
		PointLoser = pointLoser;
	}

	public int GetIdFirst() {
		return IdFirst;
	}

	public void SetIdFirst(int idFirst) {
		IdFirst = idFirst;
	}

	public int GetIdSecond() {
		return IdSecond;
	}

	public void SetIdSecond(int idSecond) {
		IdSecond = idSecond;
	}

	public int GetIdWinner() {
		return IdWinner;
	}

	public void SetIdWinner(int idWinner) {
		IdWinner = idWinner;
	}

	public int GetIdLoser() {
		return IdLoser;
	}

	public void SetIdLoser(int idLoser) {
		IdLoser = idLoser;
	}

	public String GetNameFirst() {
		return NameFirst;
	}

	public void SetNameFirst(String nameFirst) {
		NameFirst = nameFirst;
	}

	public String GetNameSecond() {
		return NameSecond;
	}

	public void SetNameSecond(String nameSecond) {
		NameSecond = nameSecond;
	}

	public String GetNameWinner() {
		return NameWinner;
	}

	public void SetNameWinner(String nameWinner) {
		NameWinner = nameWinner;
	}

	public String GetNameLoser() {
		return NameLoser;
	}

	public void SetNameLoser(String nameLoser) {
		NameLoser = nameLoser;
	}

	// prepara o combate
	public void Play() {
		InvokeFighter();
		CheckOut();
	}

	// controle de acoes
	private void InvokeFighter() {

		for (int i = 0; i < First.GetActionsList().size(); i++) {

			if (First.GetActionsList().get(i).GetPower() == 1 && Second.GetActionsList().get(i).GetPower() == 0
					&& !KO) {
				FirstAttackPower(i);
				continue;
			}

			if (Second.GetActionsList().get(i).GetPower() == 1 && First.GetActionsList().get(i).GetPower() == 0
					&& !KO) {
				SecondAttackPower(i);
				continue;
			}

			if (First.GetActionsList().get(i).GetPower() == 1 && Second.GetActionsList().get(i).GetPower() == 1
					&& !KO) {
				if (First.GetActionsList().get(i).GetModalidade() > Second.GetActionsList().get(i).GetModalidade())
					FirstAttackPower(i);
				else if (First.GetActionsList().get(i).GetModalidade() < Second.GetActionsList().get(i).GetModalidade())
					SecondAttackPower(i);

				continue;
			}

			if (First.GetActionsList().get(i).GetPunch() == 1 && Second.GetActionsList().get(i).GetPunch() == 1
					&& !KO) {
				if (First.GetActionsList().get(i).GetModalidade() > Second.GetActionsList().get(i).GetModalidade())
					FirstAttackSimplePunch(i);
				else if (First.GetActionsList().get(i).GetModalidade() < Second.GetActionsList().get(i).GetModalidade())
					SecondAttackSimplePunch(i);

				continue;
			}

			if (First.GetActionsList().get(i).GetPunch() == 1 && !KO)
				FirstAttackSimplePunch(i);

			if (Second.GetActionsList().get(i).GetPunch() == 1 && !KO)
				SecondAttackSimplePunch(i);

			if (First.GetActionsList().get(i).GetKick() == 1 && Second.GetActionsList().get(i).GetKick() == 1 && !KO) {
				if (First.GetActionsList().get(i).GetModalidade() > Second.GetActionsList().get(i).GetModalidade())
					FirstAttackSimpleKick(i);
				else if (First.GetActionsList().get(i).GetModalidade() < Second.GetActionsList().get(i).GetModalidade())
					SecondAttackSimpleKick(i);

				continue;
			}

			if (First.GetActionsList().get(i).GetKick() == 1 && !KO)
				FirstAttackSimpleKick(i);

			if (Second.GetActionsList().get(i).GetKick() == 1 && !KO)
				SecondAttackSimpleKick(i);

			if (KO)
				break;

		}
	}

	// controle de dano
	private void FirstAttackPower(int i) {
		if (Second.GetActionsList().get(i).GetDefense() == 1) {
			Second.SetLifeDamage(First.GetSkills(First.GetActionsList().get(i).GetModalidade()).GetDamage() / 2);
			First.SetPoint(1);
		} else {
			Second.SetLifeDamage(First.GetSkills(First.GetActionsList().get(i).GetModalidade()).GetDamage());
			First.SetPoint(2);
		}
	}

	private void SecondAttackPower(int i) {
		if (First.GetActionsList().get(i).GetDefense() == 1) {
			First.SetLifeDamage(Second.GetSkills(Second.GetActionsList().get(i).GetModalidade()).GetDamage() / 2);
			Second.SetPoint(1);
		} else {
			First.SetLifeDamage(Second.GetSkills(Second.GetActionsList().get(i).GetModalidade()).GetDamage());
			Second.SetPoint(2);
		}
	}

	private void FirstAttackSimplePunch(int i) {
		if (Second.GetActionsList().get(i).GetKick() == 1) {
			if (Second.GetActionsList().get(i).GetModalidade() <= First.GetActionsList().get(i).GetModalidade()) {
				Second.SetLifeDamage(First.GetPunch());
				First.SetPoint(1);
			} else if (Second.GetActionsList().get(i).GetDefense() != 1) {
				Second.SetLifeDamage(First.GetPunch());
				First.SetPoint(1);
			}
		}
	}

	private void SecondAttackSimplePunch(int i) {
		if (First.GetActionsList().get(i).GetKick() == 1) {
			if (First.GetActionsList().get(i).GetModalidade() <= Second.GetActionsList().get(i).GetModalidade()) {
				First.SetLifeDamage(Second.GetPunch());
				Second.SetPoint(1);
			}
		} else if (First.GetActionsList().get(i).GetDefense() != 1) {
			First.SetLifeDamage(Second.GetPunch());
			Second.SetPoint(1);
		}
	}

	private void FirstAttackSimpleKick(int i) {
		if (Second.GetActionsList().get(i).GetPunch() == 1) {
			if (Second.GetActionsList().get(i).GetModalidade() <= First.GetActionsList().get(i).GetModalidade()) {
				Second.SetLifeDamage(First.GetKick());
				First.SetPoint(1);
			}
		} else if (Second.GetActionsList().get(i).GetDefense() != 1) {
			Second.SetLifeDamage(First.GetKick());
			First.SetPoint(1);
		}
	}

	private void SecondAttackSimpleKick(int i) {
		if (First.GetActionsList().get(i).GetPunch() == 1) {
			if (First.GetActionsList().get(i).GetModalidade() <= Second.GetActionsList().get(i).GetModalidade()) {
				First.SetLifeDamage(Second.GetKick());
				Second.SetPoint(1);
			}
		} else if (First.GetActionsList().get(i).GetDefense() != 1) {
			First.SetLifeDamage(Second.GetKick());
			Second.SetPoint(1);
		}
	}

	// verifica fim do jogo
	private void CheckOut() {

		if (First.GetPoint() < Second.GetPoint()) {
			Winner = Second;
			Loser = First;
			KO = true;
			PointWinner = Second.GetPoint();
			PointLoser = First.GetPoint();
			IdFirst = First.GetId();
			IdSecond = Second.GetId();
			IdWinner = Second.GetId();
			IdLoser = First.GetId();
		} else if (Second.GetPoint() < First.GetPoint()) {
			Winner = First;
			Loser = Second;
			KO = true;
			PointWinner = First.GetPoint();
			PointLoser = Second.GetPoint();
			IdFirst = Second.GetId();
			IdSecond = First.GetId();
			IdWinner = First.GetId();
			IdLoser = Second.GetId();
		} else if (First.GetLife() < Second.GetLife()) {
			Winner = Second;
			Loser = First;
			KO = true;
			PointWinner = Second.GetPoint();
			PointLoser = First.GetPoint();
			IdFirst = First.GetId();
			IdSecond = Second.GetId();
			IdWinner = Second.GetId();
			IdLoser = First.GetId();
		} else if (First.GetLife() > Second.GetLife()) {
			Winner = First;
			Loser = Second;
			KO = true;
			PointWinner = First.GetPoint();
			PointLoser = Second.GetPoint();
			IdFirst = Second.GetId();
			IdSecond = First.GetId();
			IdWinner = First.GetId();
			IdLoser = Second.GetId();
		} else {
			Winner = First;
			Loser = Second;
			KO = true;
			PointWinner = First.GetPoint();
			PointLoser = Second.GetPoint();
			IdFirst = Second.GetId();
			IdSecond = First.GetId();
			IdWinner = First.GetId();
			IdLoser = Second.GetId();
		}

		View.ExecucaoLutadores(Winner, Loser);
	}
}
