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

	public String getCategory() {
		return Category;
	}

	public int getIdChampionship() {
		return IdChampionship;
	}

	public void setIdChampionship(int idChampionship) {
		IdChampionship = idChampionship;
	}

	public boolean isKO() {
		return KO;
	}

	public void setKO(boolean kO) {
		KO = kO;
	}

	public int getIdFirst() {
		return IdFirst;
	}

	public void setIdFirst(int idFirst) {
		IdFirst = idFirst;
	}

	public int getIdSecond() {
		return IdSecond;
	}

	public void setIdSecond(int idSecond) {
		IdSecond = idSecond;
	}

	public int getIdWinner() {
		return IdWinner;
	}

	public void setIdWinner(int idWinner) {
		IdWinner = idWinner;
	}

	public int getIdLoser() {
		return IdLoser;
	}

	public void setIdLoser(int idLoser) {
		IdLoser = idLoser;
	}

	public int getPointWinner() {
		return PointWinner;
	}

	public void setPointWinner(int pointWinner) {
		PointWinner = pointWinner;
	}

	public int getPointLoser() {
		return PointLoser;
	}

	public void setPointLoser(int pointLoser) {
		PointLoser = pointLoser;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public int GetId() {
		return Id;
	}

	public String GetName() {
		return Name;
	}

	public Fighter GetPrimeiro() {
		return First;
	}

	public Fighter GetSegundo() {
		return Second;
	}

	// prepara o combate
	public void Play() {
		InvokeFighter();
		CheckOut();
	}

	// controle de acoes
	private void InvokeFighter() {

		for (int i = 0; i < First.GetActionsList().size(); i++) {

			if (First.GetActionsList().get(i).getPower() == 1 && Second.GetActionsList().get(i).getPower() == 0
					&& !KO) {
				FirstAttackPower(i);
				continue;
			}

			if (Second.GetActionsList().get(i).getPower() == 1 && First.GetActionsList().get(i).getPower() == 0
					&& !KO) {
				SecondAttackPower(i);
				continue;
			}

			if (First.GetActionsList().get(i).getPower() == 1 && Second.GetActionsList().get(i).getPower() == 1
					&& !KO) {
				if (First.GetActionsList().get(i).getModalidade() > Second.GetActionsList().get(i).getModalidade())
					FirstAttackPower(i);
				else if (First.GetActionsList().get(i).getModalidade() < Second.GetActionsList().get(i).getModalidade())
					SecondAttackPower(i);

				continue;
			}

			if (First.GetActionsList().get(i).getPunch() == 1 && Second.GetActionsList().get(i).getPunch() == 1
					&& !KO) {
				if (First.GetActionsList().get(i).getModalidade() > Second.GetActionsList().get(i).getModalidade())
					FirstAttackSimplePunch(i);
				else if (First.GetActionsList().get(i).getModalidade() < Second.GetActionsList().get(i).getModalidade())
					SecondAttackSimplePunch(i);

				continue;
			}

			if (First.GetActionsList().get(i).getPunch() == 1 && !KO)
				FirstAttackSimplePunch(i);

			if (Second.GetActionsList().get(i).getPunch() == 1 && !KO)
				SecondAttackSimplePunch(i);

			if (First.GetActionsList().get(i).getKick() == 1 && Second.GetActionsList().get(i).getKick() == 1 && !KO) {
				if (First.GetActionsList().get(i).getModalidade() > Second.GetActionsList().get(i).getModalidade())
					FirstAttackSimpleKick(i);
				else if (First.GetActionsList().get(i).getModalidade() < Second.GetActionsList().get(i).getModalidade())
					SecondAttackSimpleKick(i);

				continue;
			}

			if (First.GetActionsList().get(i).getKick() == 1 && !KO)
				FirstAttackSimpleKick(i);

			if (Second.GetActionsList().get(i).getKick() == 1 && !KO)
				SecondAttackSimpleKick(i);

			if (KO)
				break;

		}
	}

	// controle de dano
	private void FirstAttackPower(int i) {
		if (Second.GetActionsList().get(i).getDefense() == 1) {
			Second.SetLifeDamage(First.GetSkills(First.GetActionsList().get(i).getModalidade()).GetDamage() / 2);
			First.SetPoint(1);
		} else {
			Second.SetLifeDamage(First.GetSkills(First.GetActionsList().get(i).getModalidade()).GetDamage());
			First.SetPoint(2);
		}
	}

	private void SecondAttackPower(int i) {
		if (First.GetActionsList().get(i).getDefense() == 1) {
			First.SetLifeDamage(Second.GetSkills(Second.GetActionsList().get(i).getModalidade()).GetDamage() / 2);
			Second.SetPoint(1);
		} else {
			First.SetLifeDamage(Second.GetSkills(Second.GetActionsList().get(i).getModalidade()).GetDamage());
			Second.SetPoint(2);
		}
	}

	private void FirstAttackSimplePunch(int i) {
		if (Second.GetActionsList().get(i).getKick() == 1) {
			if (Second.GetActionsList().get(i).getModalidade() <= First.GetActionsList().get(i).getModalidade()) {
				Second.SetLifeDamage(First.GetPunch());
				First.SetPoint(1);
			} else if (Second.GetActionsList().get(i).getDefense() != 1) {
				Second.SetLifeDamage(First.GetPunch());
				First.SetPoint(1);
			}
		}
	}

	private void SecondAttackSimplePunch(int i) {
		if (First.GetActionsList().get(i).getKick() == 1) {
			if (First.GetActionsList().get(i).getModalidade() <= Second.GetActionsList().get(i).getModalidade()) {
				First.SetLifeDamage(Second.GetPunch());
				Second.SetPoint(1);
			}
		} else if (First.GetActionsList().get(i).getDefense() != 1) {
			First.SetLifeDamage(Second.GetPunch());
			Second.SetPoint(1);
		}
	}

	private void FirstAttackSimpleKick(int i) {
		if (Second.GetActionsList().get(i).getPunch() == 1) {
			if (Second.GetActionsList().get(i).getModalidade() <= First.GetActionsList().get(i).getModalidade()) {
				Second.SetLifeDamage(First.GetKick());
				First.SetPoint(1);
			}
		} else if (Second.GetActionsList().get(i).getDefense() != 1) {
			Second.SetLifeDamage(First.GetKick());
			First.SetPoint(1);
		}
	}

	private void SecondAttackSimpleKick(int i) {
		if (First.GetActionsList().get(i).getPunch() == 1) {
			if (First.GetActionsList().get(i).getModalidade() <= Second.GetActionsList().get(i).getModalidade()) {
				First.SetLifeDamage(Second.GetKick());
				Second.SetPoint(1);
			}
		} else if (First.GetActionsList().get(i).getDefense() != 1) {
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

	public Fighter GetWinner() {
		return Winner;
	}

	public Fighter GetLoser() {
		return Loser;
	}
}
